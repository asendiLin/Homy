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

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.LoginBean;
import com.bojue.homy.presenter.login_register.LoginAndRegisterPresenter;
import com.bojue.homy.utils.https.click.ButtonEvent;
import com.bojue.homy.view.IView;
import com.bojue.homy.view.activity.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.internal.schedulers.ExecutorScheduler;

import static com.bojue.homy.utils.https.date.DateUtil.getSystemDate;

/**
 * Created by Xie on 2018/1/15.
 * 登陆界面
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener,LoginView{
    private final String TAG="SEN_DI";


    private Button login;//登陆按钮
    private TextView register;//注册
    private Intent intent;
    private TextView txt_title;//标题
    private EditText login_phone = null;
    private EditText login_password = null;
    private String mInPhone;//测试的登陆手机号码
    private String mInPassWord;//测试的登陆密码
    private LoginAndRegisterPresenter mLoginAndRegisterPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        initView();
        initData();
    }
    public void initView(){
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        txt_title = findViewById(R.id.txt_title);
        login_phone = findViewById(R.id.login_phone);
        login_password = findViewById(R.id.login_password);

        ButtonEvent buttonEvent=new ButtonEvent.Builder()
                .setOnClickListener(new ButtonEvent.OnFirstClickListener() {
                    @Override
                    public void onClick(View view) {
                        //登录
                        Log.i(TAG, "onClick: ===登录====");
                        mInPhone = login_phone.getText().toString().trim();//需要设置在里面，否则传不到
                        mInPassWord = login_password.getText().toString().trim();
                        if (mInPhone.length() == 11){
                            if (mInPassWord.length() >= 6){
                                //将手机号码和密码发送到后台
                                mLoginAndRegisterPresenter.login(mInPhone,mInPassWord);
                            }else {
                                Toast.makeText(LoginActivity.this,"请输入至少八位密码",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(LoginActivity.this,"请输入正确的手机号码",Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setView(login)
                .build();
        buttonEvent.registerClick();
    }
    public void initData() {
        txt_title.setText("登陆");
//        login.setOnClickListener(this);

        register.setOnClickListener(this);
        mLoginAndRegisterPresenter = new LoginAndRegisterPresenter();
        mLoginAndRegisterPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:

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

    /**
     * 登陆
     */
    @Override
    public void submitLogin(LoginBean mBean) {
        mInPhone = login_phone.getText().toString().trim();//需要设置在里面，否则传不到
        mInPassWord = login_password.getText().toString().trim();
        Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
