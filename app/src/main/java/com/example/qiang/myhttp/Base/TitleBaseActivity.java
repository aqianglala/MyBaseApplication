package com.example.qiang.myhttp.Base;

import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.qiang.myhttp.R;


/**
 * 带标题的Activity
 * Created by Administrator on 2015/6/2.
 */
public abstract class TitleBaseActivity extends BaseActivity implements View.OnClickListener{


    private TextView tv_left;
    private TextView tv_title;
    private TextView tv_right;

    @Override
    protected void initContentView() {
        setTheme(R.style.theme_TitleBar);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); //声明使用自定义标题
        setContentView(getContentView());
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.layout_toolbar);
        initTitlebar();
    }

    /**
     * 初始化标题栏
     */
    private void initTitlebar() {
        tv_left = (TextView) findViewById(R.id.tv_left);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_right = (TextView) findViewById(R.id.tv_right);
        tv_left.setOnClickListener(this);
    }

    /**
     * 获取返回按钮点击事件
     *
     * @return
     */
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tv_left){
            finish();
        }
    }

    /**
     * 设置标题
     *
     * @param title
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        tv_title.setText(title);
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


}
