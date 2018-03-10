package com.bojue.homy.view.activity.land_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.presenter.login.AbstractLoginPresenter;
import com.bojue.homy.presenter.login.LoginPresenter;
import com.bojue.homy.view.activity.MainActivity;

import com.bojue.homy.utils.https.click.ButtonEvent;
import com.bojue.homy.view.IView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.internal.schedulers.ExecutorScheduler;

import static com.bojue.homy.utils.https.date.DateUtil.getSystemDate;

/**
 * Created by Xie on 2018/1/15.
 * 登陆界面
 * 手机号码为123，密码为123
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener,IView{
    private final String TAG="SEN_DI";


    private Button login;//登陆按钮
    private ImageButton login_wechat;
    private ImageButton login_qq;
    private TextView register;//注册
    private Intent intent;
    private TextView txt_title;//标题
    private EditText login_phone = null;
    private EditText login_password = null;
    private String mInPhone;//测试的登陆手机号码
    private String mInPassWord;//测试的登陆密码

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        initView();
        initData();
    }
    public void initView(){
        login = findViewById(R.id.login);
        login_wechat = findViewById(R.id.login_wechat);
        login_qq = findViewById(R.id.login_qq);
        register = findViewById(R.id.register);
        txt_title = findViewById(R.id.txt_title);
        login_phone = findViewById(R.id.login_phone);
        login_password = findViewById(R.id.login_password);

        ButtonEvent buttonEvent=new ButtonEvent.Builder()
                .setOnClickListener(new ButtonEvent.OnFirstClickListener() {
                    @Override
                    public void onClick(View view) {
                        //登录
                        Toast.makeText(LoginActivity.this, "登录", Toast.LENGTH_SHORT).show();
                        Log.i(TAG, "onClick: ===登录====");
                    }
                })
                .setView(login)
                .build();
        buttonEvent.registerClick();
    }
    public void initData() {
        txt_title.setText("登陆");
//        login.setOnClickListener(this);
        login_wechat.setOnClickListener(this);
        login_qq.setOnClickListener(this);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                mInPhone = login_phone.getText().toString().trim();//需要设置在里面，否则传不到
                mInPassWord = login_password.getText().toString().trim();


//                if(mInPhone.equals("123") && mInPassWord.equals("123")){
//                    //显示当前时间
//                    long currentTime = System.currentTimeMillis();
//                    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//                    Date date = new Date(currentTime);
//                    Toast.makeText(this,"你当前登陆的时间为"+ format.format(date),Toast.LENGTH_SHORT).show();
//
//                    UserManage.getInstance().saveUserInfo(LoginActivity.this,mInPhone,mInPassWord);//将phone和password存储到SharedPreferences
//                    intent = new Intent(this,MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else {
//                    Toast.makeText(this,"手机号码/密码错误",Toast.LENGTH_SHORT).show();
//                }
                break;
            case R.id.login_wechat:
                Toast.makeText(this,"微信登陆",Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_qq:
                Toast.makeText(this,"QQ登陆",Toast.LENGTH_SHORT).show();
                break;
            case R.id.register:
                intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {
        Log.i(TAG, "hideLoading: ");
    }
}
