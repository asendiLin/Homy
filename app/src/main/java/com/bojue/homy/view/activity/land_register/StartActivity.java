package com.bojue.homy.view.activity.land_register;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.view.activity.MainActivity;

/**
 * Created by Xie on 2018/1/16.
 * 开始界面
 * 1.在界面停留200ms
 * 2.调用UserManage类的hasUserInfo进行字符串判断
 */

public class StartActivity extends BaseActivity {

    private static final int GO_HOME = 0;//去主页界面
    private static final int GO_LOGIN = 1;//去登录界面
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_HOME:
                    Intent intent = new Intent(StartActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case GO_LOGIN:
                    Intent intent2 = new Intent(StartActivity.this,LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_start);
        if(UserManage.getInstance().hasUserInfo(this)){
//            mHandler.sendEmptyMessageAtTime(GO_LOGIN,200);//回到登陆界面,该方法时间延迟为系统开机时间，开机就发送
            mHandler.sendEmptyMessageDelayed(GO_LOGIN,200);//回到登陆界面，该方法时间延迟相对系统开机时间，开应用才发送
        }else {
            mHandler.sendEmptyMessageDelayed(GO_HOME,200);//回到主页界面
        }

    }
}
