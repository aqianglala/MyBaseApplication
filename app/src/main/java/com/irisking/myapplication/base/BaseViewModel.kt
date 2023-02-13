package com.irisking.myapplication.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.JsonParseException
import com.irisking.myapplication.http.ApiException
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
typealias Block<T> = suspend () -> T
typealias Error = suspend (Exception) -> Unit
typealias Cancel = suspend (Exception) -> Unit

open class BaseViewModel : ViewModel() {

    protected fun launch(
        block: Block<Unit>,
        error: Error? = null,
        cancel: Cancel? = null,
        showErrorToast: Boolean = true
    ): Job {
        //统一异常处理
        return viewModelScope.launch {
            try {
                block.invoke()
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> {
                        cancel?.invoke(e)
                    }
                    else -> {
                        onError(e, showErrorToast)
                        error?.invoke(e)
                    }
                }
            }
        }
    }

    /**
     * 创建并执行协程
     * @param block 协程中执行
     * @return Deferred<T> 继承自 Job 额外多3个方法
     */
    protected fun <T> async(block: Block<T>): Deferred<T> {
        return viewModelScope.async { block.invoke() }
    }

    /**
     * 取消协程 会抛出CancellationException
     * @param job 协程job
     */
    protected fun cancelJob(job: Job?) {
        if (job != null && job.isActive && !job.isCompleted && !job.isCancelled) {
            job.cancel()
        }
    }

    private fun onError(e: Exception, showErrorToast: Boolean) {
        when (e) {
            //接口请求错误
            is ApiException -> {
                if (showErrorToast) {
                    ToastUtils.showLong("接口请求错误，code = ${e.code}, message = ${e.message}")
                }
                LogUtils.e("接口请求错误，code = ${e.code}, message = ${e.message}")
            }
            // 网络请求失败
            is ConnectException, is SocketTimeoutException, is UnknownHostException, is HttpException -> {
                if (showErrorToast) {
                    ToastUtils.showLong("网络请求失败：${e.message}")
                }
                LogUtils.e("网络请求失败：${e.message}")
            }
            // 数据解析错误
            is JsonParseException -> {
                if (showErrorToast) {
                    ToastUtils.showLong("数据解析错误：${e.message}")
                }
                LogUtils.e("数据解析错误：${e.message}")
            }
            // 其他错误
            else -> {
                if (showErrorToast) {
                    ToastUtils.showLong(e.message ?: return)
                }
                LogUtils.e(e.message ?: return)
            }
        }
    }
}