package com.irisking.myapplication

import com.irisking.myapplication.base.BaseViewModel

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-03
 */
class MainViewModel : BaseViewModel() {
    private val mainRepository by lazy { MainRepository() }

    fun login(name: String?, password: String?){
        launch(
            block = {
                mainRepository.login(name, password)
            }
        )
    }
}