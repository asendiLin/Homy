package com.bojue.homy.utils.https.crash;

import android.content.Context;
import android.os.Process;

/**
 * Created by Administrator on 2018/1/26.
 * 处理未捕获异常
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG="CrashHandler";

    private static CrashHandler sCrashHandler=new CrashHandler();
    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;

    private Context mContext;

    private CrashHandler(){}

    public static CrashHandler getCrashHandler(){
        return sCrashHandler;
    }

    public void init(Context context){
        mUncaughtExceptionHandler=Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(mUncaughtExceptionHandler);
        mContext=context.getApplicationContext();
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //将异常信息储存到SD卡
        saveExceptionToSDCard(e);

        //将异常信息上传至服务器
        sendExceptionToServer(e);

        e.printStackTrace();

        if (mUncaughtExceptionHandler!=null){
            mUncaughtExceptionHandler.uncaughtException(t, e);
        }else{
            Process.killProcess(Process.myPid());
        }
    }

    private void sendExceptionToServer(Throwable e) {
    }

    private void saveExceptionToSDCard(Throwable e) {
    }
}
