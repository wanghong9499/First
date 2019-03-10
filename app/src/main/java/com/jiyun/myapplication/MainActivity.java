package com.jiyun.myapplication;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jiyun.myapplication.base.BaseActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<View, Presenter> implements View{

    @BindView(R.id.rlv)
    RecyclerView mRlv;
    @BindView(R.id.smart)
    SmartRefreshLayout mSmart;
    private ArrayList<Bean.NewslistBean> mList;
    private RlvAdapter mAdapter;
    private int mPage = 1;
    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    public void initData() {
        mPresenter.initData(mPage);
    }

    protected void initView() {
        mRlv.setLayoutManager(new LinearLayoutManager(this));

        mList = new ArrayList<>();
        mAdapter = new RlvAdapter(this, mList);
        mRlv.setAdapter(mAdapter);
        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mAdapter.mList.clear();
                mPage = 1;
                mPresenter.initData(mPage);
                mSmart.finishRefresh(3000);
            }
        });
        mSmart.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPage++;
//                mPage = 1;
                mPresenter.initData(mPage);
                mSmart.finishLoadmore(3000);
            }
        });

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(List<Bean.NewslistBean> list) {
        mAdapter.addData(list);
    }
}
