package com.bojue.homy.utils.https.interceptor;

import android.app.Application;
import android.util.Log;

import com.bojue.homy.base.BaseApplication;
import com.bojue.homy.utils.https.cache.SharedPreferencedUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/1/25.
 */

public class SaveCookieInterceptor implements Interceptor {
    private final String TAG = "SEN_DI";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        if (!response.header("Set-Cookie").isEmpty()) {
            String cookie = response.header("Set-Cookie");
            Log.i(TAG, "intercept: ======cookie======" + cookie);
            SharedPreferencedUtils.saveCookie(BaseApplication.getInstance(), cookie);
        }
        return response;
    }
}
