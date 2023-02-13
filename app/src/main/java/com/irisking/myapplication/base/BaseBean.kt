package com.irisking.myapplication.base

import com.irisking.myapplication.http.ApiException

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
class BaseBean<T>(private val errorCode: Int, private val data: T, private val errorMsg: String?) {
    fun code(): Int {
        if (errorCode == 0) {
            return errorCode
        } else {
            throw ApiException(errorCode, errorMsg ?: "")
        }
    }

    fun data(): T {
        if (errorCode == 0) {
            return data
        } else {
            throw ApiException(errorCode, errorMsg ?: "")
        }
    }
}