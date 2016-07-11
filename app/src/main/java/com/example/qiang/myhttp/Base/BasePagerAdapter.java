package com.example.qiang.myhttp.Base;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.qiang.myhttp.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;


public abstract class BasePagerAdapter extends FragmentStatePagerAdapter {


    /**
     *缓存fragment
     */
    public Map<Integer,BaseNetFragment>  fragmentMap;
    public  Class<? extends BaseNetFragment>[] fragments;

    public BasePagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = setFrgments();
        fragmentMap=new HashMap<Integer,BaseNetFragment>();
    }

    public abstract Class<? extends BaseNetFragment>[] setFrgments();

    @Override
    public Fragment getItem(int i) {
        if(fragmentMap.containsKey(i)){
            LogUtils.i("拿到缓存的fragment"+i);
            return fragmentMap.get(i);

        }

        Class<? extends BaseNetFragment> fragmentClass = fragments[i];
        try {
            BaseNetFragment fragment=fragmentClass.newInstance();
            fragmentMap.put(i,fragment);
            LogUtils.i("new一个frgment"+fragmentClass.getName());
            return fragment;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }


}
