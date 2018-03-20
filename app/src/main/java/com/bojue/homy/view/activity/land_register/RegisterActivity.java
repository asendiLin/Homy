package com.bojue.homy.view.activity.land_register;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.presenter.login_register.AbstractRegisterPresenter;
import com.bojue.homy.presenter.login_register.RegisterPresenter;

import static com.baidu.location.d.j.v;

/**
 * Created by Xie on 2018/1/15.
 * 注册界面
 */

public class RegisterActivity extends BaseActivity implements RegisterView,View.OnClickListener{

    private Button register;//注册按钮
    private TextView go_login;//已有账号去登陆
    private TextView txt_title;//标题
    private AbstractRegisterPresenter mPresenter;
    private EditText et_name_register;//名字
    private EditText et_password_register;//第一次输入的密码
    private EditText et_again_password_register;//再次输入的密码
    private EditText et_phone_register;//手机号码
    private EditText et_code_register;//验证码
    private Button btn_get_code_register;//获取验证码的按钮
    private String mName;
    private String mPassword;
    private String mAgainPassword;
    private String mPhoneNumber;
    private String mCode;
    private int i=5;
    private boolean temp = false;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0){//不可点击
                btn_get_code_register.setClickable(false);
                btn_get_code_register.setText("重新发送："+i+"s");
            }
            if (msg.what == 1){
                btn_get_code_register.setClickable(true);
                btn_get_code_register.setText(getResources().getString(R.string.str_hint_get_verification_Code));
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        initView();
        initData();
    }

    public void initView(){
        register = findViewById(R.id.register);
        go_login = findViewById(R.id.go_login);
        txt_title = findViewById(R.id.txt_title);
        et_name_register = findViewById(R.id.et_name_register);
        et_password_register = findViewById(R.id.et_password_register);
        et_again_password_register = findViewById(R.id.et_again_password_register);
        et_phone_register = findViewById(R.id.et_phone_register);
        et_code_register = findViewById(R.id.et_code_register);
        btn_get_code_register = findViewById(R.id.btn_get_code_register);
    }
    public void initData(){
        txt_title.setText("注册");
        register.setOnClickListener(this);
        btn_get_code_register.setOnClickListener(this);
        go_login.setOnClickListener(this);

        mName = et_name_register.getText().toString();
        et_name_register.setOnFocusChangeListener(new mOnFocusChangeListener());
        mPresenter = new RegisterPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        mName = et_name_register.getText().toString();
        mPassword = et_password_register.getText().toString();
        mAgainPassword = et_again_password_register.getText().toString();
        mPhoneNumber = et_phone_register.getText().toString().trim();
        mCode = et_code_register.getText().toString().trim();
        switch (v.getId()){
            case R.id.btn_get_code_register://获取验证码
                if (!judge(mName,mPassword,mAgainPassword)) {
                    if(mPhoneNumber.length()  == 11){
                        mPresenter.getRegisterCode(mPhoneNumber);
                    }else {
                        Toast.makeText(this,"请输入正确的手机号码",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.register://注册
                if (!judge(mName,mPassword,mAgainPassword)) {
                    if(mPhoneNumber.length()  != 11){
                        Toast.makeText(this,"请输入正确的手机号码",Toast.LENGTH_SHORT).show();
                    }else if (mCode.length()  == 6){
                        mPresenter.submitRegisterContent(mName,mPassword,mPhoneNumber,mCode);
                    }else {
                        Toast.makeText(this,"请输入正确的验证码",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.go_login:
                Toast.makeText(this,"返回上一页",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
    /*
    用户名的焦点事件
     */
    public class mOnFocusChangeListener implements View.OnFocusChangeListener {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(!hasFocus){
                mPresenter.submitCheckName(mName);
            }
        }
    }
    //验证用户名，密码的长度
    public boolean judge(String mName,String mPassword,String mAgainPassword){
        if (mName.length() >= 10) {
            Toast.makeText(this,"名字长度不能超过10位",Toast.LENGTH_SHORT).show();
            temp = true;
        }
        if(mPassword.length() <= 6){
            Toast.makeText(this,"请输入至少6位的密码",Toast.LENGTH_SHORT).show();
            temp = true;
        }
        if (!(mAgainPassword.equals(mPassword))){
            Toast.makeText(this,"两次密码输入不一致",Toast.LENGTH_SHORT).show();
            temp = true;
        }
        return temp;
    }
    /**
     * 验证用户名
     */
    @Override
    public void submitCheckName() {
        if (true) {
            Toast.makeText(this, "该用户名可以使用", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "该用户名已重复", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 获取验证码
     */
    @Override
    public void getRegisterCode() {
        Toast.makeText(this,"正在倒计时",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;i>=0;i--){
                    btn_get_code_register.setText("重新发送："+i+"s");
                    mHandler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i<0){
                    mHandler.sendEmptyMessage(1);
                }
            }
        }).start();
    }
    /**
     * 提交注册信息成功
     */
    @Override
    public void submitRegisterSuccess() {
        Toast.makeText(this,"名字,密码，手机号码，验证码提交成功",Toast.LENGTH_SHORT).show();
    }

}
