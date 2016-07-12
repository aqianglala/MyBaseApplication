package com.example.qiang.myhttp.view;

import android.os.SystemClock;

import com.example.qiang.myhttp.Base.TitleBaseActivity;
import com.example.qiang.myhttp.R;
import com.example.qiang.myhttp.dialog.LoadDialog;
import com.example.qiang.myhttp.dialog.ToastDialog;
import com.example.qiang.myhttp.utils.UIUtils;

public class MainActivity extends TitleBaseActivity {


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        final LoadDialog loadDialog = LoadDialog.show(this);
        new Thread(){
            @Override
            public void run() {
                super.run();
                SystemClock.sleep(3000);
                UIUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadDialog.dismiss();
                        ToastDialog.showError(context,"错误");
                    }
                });
            }
        }.start();
    }
}
