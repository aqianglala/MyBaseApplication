package com.irisking.myapplication

import com.irisking.myapplication.base.BaseRepository

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-03
 */
class MainRepository: BaseRepository() {
    suspend fun login(username: String?, password: String?){
        apiService().login(username, password)
    }
}