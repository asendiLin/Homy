package com.bojue.homy.view.activity.person.phone;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.presenter.person.PhonePresenter;

/**
 * Created by Xie on 2018/3/7.
 * 我的手机的界面
 */

public class MyPhoneActivity extends BaseActivity implements View.OnClickListener,MyPhoneView{
    private EditText et_number_phone;//手机号码输入框
    private Button btn_get_code_phone;//获取验证码按钮
    private EditText et_code_phone;//验证码输入框
    private Button btn_finish_phone;//完成按钮
    private PhonePresenter mPhonePresenter;
    private ImageButton ib_back_community;

    private int i=5;//倒计时
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
                if(msg.what == 0){//不可点击
                    btn_get_code_phone.setText("重新发送" + i + "s");
                    return;
                }
                if (msg.what == 1) {
                    btn_get_code_phone.setClickable(true);
                    btn_get_code_phone.setText(getResources().getString(R.string.str_hint_get_verification_Code));
                    i = 5;
                    return;
                }
                }

};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_phone);
        initView();
        initData();
    }
    private void initView(){
        et_number_phone = findViewById(R.id.et_number_phone);
        btn_get_code_phone = findViewById(R.id.btn_get_code_phone);
        et_code_phone = findViewById(R.id.et_code_phone);
        btn_finish_phone = findViewById(R.id.btn_finish_phone);
        ib_back_community = findViewById(R.id.ib_back_community);
    }
    private void initData(){
        btn_get_code_phone.setOnClickListener(this);
        btn_finish_phone.setOnClickListener(this);
        ib_back_community.setVisibility(View.VISIBLE);
        ib_back_community.setOnClickListener(this);

        mPhonePresenter = new PhonePresenter();
        mPhonePresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        String mNumber = et_number_phone.getText().toString();
        String mId = "93f176fa-5e8e-41ad-ab7b-ab49b1a0e3fb";
        switch (v.getId()){
            case R.id.btn_get_code_phone:
                //第一步：验证手机号码
                if(judgePhoneNumber(mNumber)){
                    //第二步：发送短信验证码
                    mPhonePresenter.getRegisterCode(mNumber,mId);
                    //第三步：按钮变为不可点击，且倒计时
                    btn_get_code_phone.setClickable(false);
                    btn_get_code_phone.setText("重新发送："+i+"s");
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for(;i>=0;i--) {
                                mHandler.sendEmptyMessage(0);//不可点击

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if(i < 0){
                                mHandler.sendEmptyMessage(1);//可以点击
                            }
                        }
                    }).start();
                    return;
                }

                break;
            case R.id.btn_finish_phone:

                String mCode = et_code_phone.getText().toString();

                //第一步，判断验证码位数
                if(isMatchCode(mCode,6)){
                    mPhonePresenter.submitContent(mNumber,mCode,mId);
                }else {
                    Toast.makeText(this, "验证码输入有误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ib_back_community:
                finish();
            default:
                break;
        }
    }

    private boolean judgePhoneNumber(String number){
        if(isMatchLength(number,11) && isPhoneFormat(number)){
            Toast.makeText(this, "输入成功！", Toast.LENGTH_SHORT).show();
            return true;
        }
        Toast.makeText(this, "手机号码输入有误！", Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * 判断一个字符串的位数
     * @param str
     * @param length
     * @return
     */
    public static boolean isMatchLength(String str,int length){
        if (str.isEmpty()){
            return false;
        }else {
            return str.length() == length ? true : false;
        }
    }

    /**
     * 判断验证码的位数
     * @param code
     * @param length
     * @return
     */
    public static boolean isMatchCode(String code,int length){
        if(TextUtils.isEmpty(code)){
            return false;
        }else {
            return code.length() == length ? true: false;
        }
    }
    /**
     * 验证手机格式
     * @param number
     * @return
     */
    public static boolean isPhoneFormat(String number){
        String regex = "[1][358]\\d{9}";
        if(TextUtils.isEmpty(number)){
            return false;
        }else {
            return number.matches(regex);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }

    @Override
    public void getRegisterCode() {
        Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void submitContent() {
        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
    }
}
