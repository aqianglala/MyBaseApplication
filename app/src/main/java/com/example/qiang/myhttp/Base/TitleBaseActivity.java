package com.example.qiang.myhttp.Base;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qiang.myhttp.R;


/**
 * 带标题的Activity
 * Created by Administrator on 2015/6/2.
 */
public abstract class TitleBaseActivity extends BaseActivity{

    private static final int BASE_VIEW_ID = R.layout.activity_titlebar_base;
    private static final LinearLayout.LayoutParams LAYOUT_PARAMS = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    private LinearLayout mParentView;

    private Toolbar toolbar;
    private TextView tv_left;
    private TextView tv_right;
    private TextView tv_title;

    @Override
    protected void initContentView() {
        setContentView(BASE_VIEW_ID);
        // 添加默认标题栏
        toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        // 使用toolbar作为actionBar
        setSupportActionBar(toolbar);
        // 初始化标题栏
        initTitleBar();
        mParentView = (LinearLayout) findViewById(R.id.base_parent_view);
        mParentView.addView(getLayoutInflater().inflate(getContentView(), null), LAYOUT_PARAMS);
    }

    private void initTitleBar(){
        tv_left = (TextView) toolbar.findViewById(R.id.tv_left);
        tv_title = (TextView) toolbar.findViewById(R.id.tv_title);
        tv_right = (TextView) toolbar.findViewById(R.id.tv_right);
    };

    /**
     * 设置默认标题颜色
     * @param color
     */
    public void setFirstTitleColor(int color){
        toolbar.setTitleTextColor(color);
    }

    /**
     * 设置是否显示默认标题
     * @param isShow
     */
    public void setDisplayFirstTitle(boolean isShow){
        getSupportActionBar().setDisplayShowTitleEnabled(isShow);
    }

    /**
     * 是指默认标题文字
     * @param firstTitle
     */
    public void setFirstTitle(String firstTitle){
        getSupportActionBar().setTitle(firstTitle);
    }

    /**
     * 设置是否展示返回按钮
     * @param isShowArrow
     */
    public void setDisplayHomeAsUpEnabled(boolean isShowArrow){
        if(isShowArrow){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }else{
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    /**
     * 设置标题栏左中右文字
     * @param left
     * @param title
     * @param right
     */
    public void setTitleBar(String left, String title, String right){
        tv_left.setVisibility(View.VISIBLE);
        tv_title.setVisibility(View.VISIBLE);
        tv_right.setVisibility(View.VISIBLE);
        tv_left.setText(left);
        tv_title.setText(title);
        tv_right.setText(right);
    }

    /**
     * 设置标题栏左边文字
     * @param left
     */
    public void setLeft(String left){
        tv_left.setVisibility(View.VISIBLE);
        tv_left.setText(left);
    }

    /**
     * 设置标题栏中间文字
     * @param title
     */
    public void setTitle(String title){
        tv_title.setVisibility(View.VISIBLE);
        tv_title.setText(title);
    }

    /**
     * 设置标题栏右边文字
     * @param right
     */
    public void setRight(String right){
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText(right);
    }



    /**
     * 设置标题
     *
     * @param titleId
     */
    @Override
    public void setTitle(int titleId) {
        this.setTitle(getString(titleId));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == android.R.id.home){
            finish();
        }
    }
}
