package com.jiyun.myapplication;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2019/3/10 0010.
 */

public interface ApiService {
    String mBaseUrl = "http://api.tianapi.com/";

    @GET("wxnew")
    Observable<Bean> initData(@Query("key") String key,@Query("num") int num,@Query("page") int page);
}
