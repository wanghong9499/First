package com.jiyun.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public abstract class BaseActivity<V extends BaseView,T extends BasePresenter> extends AppCompatActivity implements BaseView{
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if (mPresenter != null){
            mPresenter.attachView((V)this);
        }
        initView();
        initListener();
        initData();
    }

    protected abstract T initPresenter();

    protected void initData() {}

    protected void initListener() {}

    protected void initView() {}

    protected abstract int getLayoutId();
}
