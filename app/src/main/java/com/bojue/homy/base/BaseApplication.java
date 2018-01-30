package com.bojue.homy.base;

import android.app.Application;

import com.bojue.homy.utils.https.crash.CrashHandler;

/**
 * Created by Administrator on 2018/1/26.
 * 自定义的Application
 */

public class BaseApplication extends Application {

    private static BaseApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
        CrashHandler crashHandler=CrashHandler.getCrashHandler();
        crashHandler.init(this);
    }

    public static BaseApplication getInstance(){
        return sInstance;
    }
}
