package com.irisking.myapplication.http

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
class ApiException(val code: Int, override val message: String) : RuntimeException()