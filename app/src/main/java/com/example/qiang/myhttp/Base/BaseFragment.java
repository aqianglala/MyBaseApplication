package com.example.qiang.myhttp.Base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.qiang.myhttp.utils.LogUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/6/28.
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity baseActivity;
    protected View rootView;
    public String TAG;
    protected BaseApplication mApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TAG = this.getClass().getSimpleName();
//        为了避免每次切换 都调用此方法，创建一个view，将view保存起来。之后每次都是用原来的view
        if(rootView==null) {
            rootView = inflater.inflate(getContentView(), null);
            initView();
        }
        else{
            LogUtils.i("移除之前的view,重新添加");
            ViewParent parent = rootView.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(rootView);
            }
        }
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        baseActivity = (BaseActivity) getActivity();
        initData();
    }

    protected abstract int getContentView();

    /**
     * 每次初始化视图才调用，如果视图没有被 销毁，则不调用，用来初始化监听。或者其他
     */
    protected void initView() {
        ButterKnife.bind(this, rootView);
    }

    /**
     * 初始化数据的方法。基本每次都调用
     */
    protected void initData() {

    }

}