package com.bojue.homy.utils.https;

import com.bojue.homy.global.GlobalContent;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/1/6.
 * 创建Service实例
 */

public class RetrofitFactory {
    private static Retrofit mRetorfit;

    private RetrofitFactory(){}

    public static <T> T getService(Class<T> service){
        if (mRetorfit==null){
            synchronized (RetrofitFactory.class){
                if (mRetorfit==null){
                    mRetorfit=new Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(GlobalContent.BASEURL)
                            .build();
                }
            }
        }
        return mRetorfit.create(service);
    }
}
