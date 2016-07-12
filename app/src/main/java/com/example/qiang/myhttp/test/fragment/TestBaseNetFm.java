package com.example.qiang.myhttp.test.fragment;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qiang.myhttp.Base.BaseNetFragment;
import com.example.qiang.myhttp.R;
import com.example.qiang.myhttp.utils.UIUtils;
import com.example.qiang.myhttp.widget.LoadingPage;

import java.util.ArrayList;

/**
 * Created by qiang on 2016/7/11.
 */
public class TestBaseNetFm extends BaseNetFragment {

    private ArrayList<String> mData;

    @Override
    public View onCreateSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_test);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(UIUtils.getContext(),
                android.R.layout.simple_list_item_1, mData);
        listView.setAdapter(adapter);
        return view;
    }

    @Override
    public LoadingPage.ResultState onLoad() {
        mData = new ArrayList<>();
        for(int i=0;i<20;i++){
            mData.add("第"+i+"条数据");
        }
        return check(mData);
    }
}
