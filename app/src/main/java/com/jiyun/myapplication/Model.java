package com.jiyun.myapplication;

import com.jiyun.myapplication.base.BaseModel;
import com.jiyun.myapplication.net.BaseObserver;
import com.jiyun.myapplication.net.HttpUtils;
import com.jiyun.myapplication.net.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public class Model extends BaseModel {
    public void initData(int page, final ResultCallBack resultCallBack) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.mBaseUrl, ApiService.class);
        Observable<Bean> data = apiserver.initData("52b7ec3471ac3bec6846577e79f20e4c", 10, page);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        resultCallBack.onSuccess(bean.getNewslist());
                    }
                });
    }
}
