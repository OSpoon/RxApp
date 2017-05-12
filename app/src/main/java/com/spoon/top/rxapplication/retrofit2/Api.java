package com.spoon.top.rxapplication.retrofit2;

import com.spoon.top.rxapplication.bean.GankAndroid;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by zhanxiaolin-n22 on 2017/5/12.
 */

public interface Api {

    @GET("/api/data/Android/10/1")
    Observable<GankAndroid> getGankAndroid();
}
