package com.irisking.myapplication.data.bean

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-03
 */
data class User(
    var admin: Boolean,
    var chapterTops: List<Any>,
    var coinCount: Int,
    var collectIds: List<Int>,
    var email: String,
    var icon: String,
    var id: Int,
    var nickname: String,
    var password: String,
    var publicName: String,
    var token: String,
    var type: Int,
    var username: String
)
