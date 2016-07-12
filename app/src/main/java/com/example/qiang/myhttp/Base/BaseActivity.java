package com.example.qiang.myhttp.Base;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.qiang.myhttp.utils.LogUtils;

import butterknife.ButterKnife;


/**
 * Activity的基类
 * Created by Administrator on 2015/6/2.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    public String TAG;
    protected BaseActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        // 添加到activity管理类中
        BaseApplication.addActivity(this);
        TAG = this.getClass().getSimpleName();

        initContentView();
        initialize();
        initView();
        initListener();
    }

    protected void initView(){}

    protected void initListener() {}

    /**
     * 初始化界面
     * 1.设置屏幕方向
     * 2.设置默认背景颜色
     * 3.设置默认文字颜色
     */
    protected void initContentView() {
        setContentView(getContentView());
    }

    protected abstract int getContentView();


    /**
     * 初始化
     */
    protected void initialize() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        LogUtils.i(TAG,"关闭请求");
        BaseApplication.removeActivity(this);
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }

    protected FragmentTransaction transaction;

    /**
     * 添加fragment，并且添加进返回栈
     *
     * @param fragment
     * @param bundle
     */
    public void addFragment(BaseFragment fragment, Bundle bundle, int contentId) {

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(contentId, fragment);
        fragment.setArguments(bundle);
        transaction.addToBackStack("");
        transaction.commit();
    }

    public void addFragment(BaseFragment fragment, int contentId) {
        addFragment(fragment, null, contentId);
    }

    /**
     * 替换fragment
     *
     * @param fragment
     * @param bundle
     */
    public void replaceFragment(BaseFragment fragment, Bundle bundle, int contentId) {

        replaceFragment(fragment, bundle, contentId, true);
    }

    public void replaceFragment(BaseFragment fragment, Bundle bundle, int contentId, boolean addToBackStack) {

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(contentId, fragment);
        fragment.setArguments(bundle);
        if (addToBackStack) {
            transaction.addToBackStack("");
        }
        transaction.commit();

    }

    public void replaceFragment(BaseFragment fragment, int contentId) {
        replaceFragment(fragment, null, contentId);
    }

    public void replaceFragment(BaseFragment fragment, int contentId, boolean addToBackStack) {
        replaceFragment(fragment, null, contentId, addToBackStack);
    }

}
