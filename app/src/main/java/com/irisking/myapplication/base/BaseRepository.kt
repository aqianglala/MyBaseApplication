package com.irisking.myapplication.base

import com.irisking.myapplication.http.Api
import com.irisking.myapplication.http.RetrofitClient

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-03
 */
open class BaseRepository {

    protected fun apiService(): Api {
        return RetrofitClient.getApiService()
    }
}