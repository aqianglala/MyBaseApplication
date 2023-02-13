package com.irisking.myapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

/**
 *
 *
 * @author tangzhaoqiang
 * @since 2023-02-02
 */
abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel>(private val inflate: (LayoutInflater) -> VB) :
    AppCompatActivity() {
    protected lateinit var mBinding: VB
    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = inflate(layoutInflater)
        setContentView(mBinding.root)
        initViewModel()
        initView()
        initData()
        setListener()
    }

    private fun initViewModel() {
        mViewModel = ViewModelProvider(this)[viewModelClass()]
    }

    abstract fun viewModelClass(): Class<VM>

    abstract fun initView()

    abstract fun initData()

    abstract fun setListener()
}