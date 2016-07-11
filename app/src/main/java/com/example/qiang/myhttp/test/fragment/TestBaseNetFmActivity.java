package com.example.qiang.myhttp.test.fragment;

import android.support.v4.view.ViewPager;

import com.example.qiang.myhttp.Base.BaseNetFragment;
import com.example.qiang.myhttp.Base.BasePagerAdapter;
import com.example.qiang.myhttp.Base.TitleBaseActivity;
import com.example.qiang.myhttp.R;

import butterknife.Bind;

public class TestBaseNetFmActivity extends TitleBaseActivity {

    @Bind(R.id.viewPager)ViewPager viewPager;

    @Override
    protected int getContentView() {
        return R.layout.activity_test_base_net_fm;
    }

    @Override
    protected void initListener() {
        super.initListener();
        viewPager.setAdapter(new BasePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Class<? extends BaseNetFragment>[] setFrgments() {
                return null;
            }
        });
    }

}
