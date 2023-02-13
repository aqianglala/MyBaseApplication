package com.irisking.myapplication

import android.app.Application
import com.blankj.utilcode.util.LogUtils
import com.irisking.myapplication.common.MyConfig

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initUtil()
    }

    private fun initUtil() {
        LogUtils.getConfig().apply {
            globalTag = MyConfig.LOG_TAG
            isLog2FileSwitch = true
            dir = MyConfig.LOG_FILE_PATH
            saveDays = 7
            setFileFilter(LogUtils.E)
            isLogSwitch = true
        }
    }
}