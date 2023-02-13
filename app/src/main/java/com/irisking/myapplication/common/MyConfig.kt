package com.irisking.myapplication.common

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
object MyConfig {
    private const val FILE_PATH_ROOT = "/sdcard/MyWanandroid"
    private const val LOG_PATH: String = "$FILE_PATH_ROOT/log"
    const val LOG_TAG = "LogHistory"
    const val LOG_FILE_PATH: String = "$LOG_PATH/LogHistory"
}