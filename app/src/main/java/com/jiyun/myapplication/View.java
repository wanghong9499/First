package com.jiyun.myapplication;

import com.jiyun.myapplication.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public interface View extends BaseView{
    void setData(List<Bean.NewslistBean> list);
}
