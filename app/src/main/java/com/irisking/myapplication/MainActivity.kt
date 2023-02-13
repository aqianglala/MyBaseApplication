package com.irisking.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.irisking.myapplication.base.BaseActivity
import com.irisking.myapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(ActivityMainBinding::inflate) {
    override fun viewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun setListener() {
        mBinding.btnHello.setOnClickListener {
            mViewModel.login("aqianglala", "88661213")
        }
    }

}