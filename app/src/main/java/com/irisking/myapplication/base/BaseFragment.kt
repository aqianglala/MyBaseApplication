package com.irisking.myapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
abstract class BaseFragment<VB : ViewBinding>(private val inflate: (LayoutInflater) -> VB) :
    Fragment() {

    protected lateinit var mBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = inflate(layoutInflater)
        initView()
        initData()
        return mBinding.root
    }

    abstract fun initView()

    abstract fun initData()
}