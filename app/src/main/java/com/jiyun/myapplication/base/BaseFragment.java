package com.jiyun.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public abstract class BaseFragment<V extends BaseView,T extends BasePresenter> extends Fragment {

    protected Unbinder mUnbinder;
    protected T mPresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        mUnbinder = ButterKnife.bind(view);
        mPresenter = initPresenter();
        if (mPresenter != null){
            mPresenter.attachView((V)this);
        }
        initView(view);
        initData();
        initListener();
        return view;
    }

    protected abstract T initPresenter();

    protected void initData() {}

    protected void initListener() {}

    protected void initView(View view) {}

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
