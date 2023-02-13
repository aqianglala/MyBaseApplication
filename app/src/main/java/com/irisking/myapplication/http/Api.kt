package com.irisking.myapplication.http

import com.irisking.myapplication.base.BaseBean
import com.irisking.myapplication.data.bean.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
interface Api {
    companion object{
        const val BASE_URL = "https://www.wanandroid.com/"
    }

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@Field("username") username: String?, @Field("password") password: String?): BaseBean<User>
}