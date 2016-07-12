package com.example.qiang.myhttp.test.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.qiang.myhttp.Base.BaseNetFragment;
import com.example.qiang.myhttp.Base.TitleBaseActivity;
import com.example.qiang.myhttp.R;
import com.example.qiang.myhttp.test.fragment.TestBaseNetFm;

import java.util.ArrayList;

import butterknife.Bind;

public class TestBaseNetFmActivity extends TitleBaseActivity {

    @Bind(R.id.viewPager)ViewPager viewPager;
    private ArrayList<BaseNetFragment> fragments;

    @Override
    protected int getContentView() {
        return R.layout.activity_test_base_net_fm;
    }

    @Override
    protected void initListener() {
        super.initListener();
        fragments = new ArrayList<>();
        for(int i=0;i<5;i++){
            fragments.add(new TestBaseNetFm());
        }
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(onPageChangeListener);
        viewPager.post(new Runnable(){
            @Override
            public void run() {
                onPageChangeListener.onPageSelected(0);
            }
        });
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    private ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            fragments.get(position).loadData();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
