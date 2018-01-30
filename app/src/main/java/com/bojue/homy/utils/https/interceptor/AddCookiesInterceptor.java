package com.bojue.homy.utils.https.interceptor;

import android.app.Application;
import android.util.Log;

import com.bojue.homy.base.BaseApplication;
import com.bojue.homy.utils.https.cache.SharedPreferencedUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/1/25.
 */

public class AddCookiesInterceptor implements Interceptor {
    private final String TAG="SEN_DI";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder=chain.request().newBuilder();
        builder.addHeader("Cookie", SharedPreferencedUtils.
                getCookie(BaseApplication.getInstance()));

            return chain.proceed(builder.build());
    }
}
