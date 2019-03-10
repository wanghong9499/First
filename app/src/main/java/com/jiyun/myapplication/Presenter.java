package com.jiyun.myapplication;

import com.jiyun.myapplication.base.BasePresenter;
import com.jiyun.myapplication.net.ResultCallBack;

import java.util.List;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public class Presenter extends BasePresenter<View> {

    private Model mModel;

    @Override
    protected void initModel() {
        mModel = new Model();
    }

    public void initData(int  page) {
        mModel.initData(page,new ResultCallBack<Bean.NewslistBean>(){
            @Override
            public void onSuccess(List<Bean.NewslistBean> list) {
                mView.setData(list);
            }
        });
    }
}
