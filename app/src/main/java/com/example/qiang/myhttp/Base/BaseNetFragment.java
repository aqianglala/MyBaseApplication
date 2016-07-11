package com.example.qiang.myhttp.Base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qiang.myhttp.utils.UIUtils;
import com.example.qiang.myhttp.widget.LoadingPage;

import java.util.ArrayList;


public abstract class BaseNetFragment extends Fragment {

	private LoadingPage mLoadingPage;

	// 初始化fragment布局
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TextView view = new TextView(UIUtils.getContext());
		// view.setText(getClass().getSimpleName());// 将当前类名设置给textview
		mLoadingPage = new LoadingPage(UIUtils.getContext()) {

			@Override
			public View onCreateSuccessView() {
				// BaseNetFragment不知道子类加载成功的布局如何实现, 所以此处转由子类来实现加载成功的布局
				return BaseNetFragment.this.onCreateSuccessView();// 注意:此处一定要使用BaseNetFragment的方法,否则栈溢出
			}

			@Override
			public ResultState onLoad() {
				return BaseNetFragment.this.onLoad();
			}

		};

		return mLoadingPage;
	}

	// 此方法来初始化加载成功的布局,必须由子类来实现
	public abstract View onCreateSuccessView();

	// 加载网络数据, 必须子类实现
	public abstract LoadingPage.ResultState onLoad();

	/**
	 * 加载数据
	 */
	public void loadData() {
		if (mLoadingPage != null) {
			mLoadingPage.loadData();
		}
	}

	/**
	 * 校验数据合法性
	 * 
	 * @param obj
	 * @return
	 */
	public LoadingPage.ResultState check(Object obj) {
		if (obj != null) {
			if (obj instanceof ArrayList) {
				ArrayList list = (ArrayList) obj;

				if (!list.isEmpty()) {
					return LoadingPage.ResultState.LOAD_SUCCESS;
				} else {
					return LoadingPage.ResultState.LOAD_EMPTY;// 数据为空
				}
			}
		}

		return LoadingPage.ResultState.LOAD_ERROR;
	}
}
