package com.jiyun.myapplication.base;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public abstract class BasePresenter<V extends BaseView> {
    protected V mView;

    protected BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    protected  void attachView(V view){

        mView = view;
    };
}
