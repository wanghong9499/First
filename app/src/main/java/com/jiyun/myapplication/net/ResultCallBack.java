package com.jiyun.myapplication.net;

import java.util.List;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public interface ResultCallBack<T> {
    void onSuccess(List<T> list);
}
