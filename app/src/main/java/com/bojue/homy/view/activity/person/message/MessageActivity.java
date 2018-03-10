package com.bojue.homy.view.activity.person.message;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.utils.https.activity.ActivityController;
import com.bojue.homy.view.activity.land_register.LoginActivity;
import com.bojue.homy.view.activity.land_register.UserManage;
import com.bojue.homy.view.activity.person.demand.MyDemandView;
import com.bojue.homy.view.fragment.person.IPersonView;

import java.util.List;

/**
 * Created by Xie on 2018/1/12.
 * 编辑个人信息界面
 * 1.昵称
 * 2.性别
 * 3.手机号码
 * 4.退出登录
 */

public class MessageActivity extends BaseActivity implements IPersonView,View.OnClickListener {

    private ImageButton ib_back_community;//返回按钮
    private Button ib_send_feeling_content;//发送按钮
    private Button drop_out;//退出登录
    private SharedPreferences mSharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_msg);
        initView();
        initData();
    }

    public void initView(){
        ib_back_community = findViewById(R.id.ib_back_community);
        ib_back_community.setVisibility(View.VISIBLE);
        ib_back_community.setOnClickListener(this);
        ib_send_feeling_content = findViewById(R.id.ib_send_feeling_content);
        ib_send_feeling_content.setVisibility(View.VISIBLE);
        ib_send_feeling_content.setOnClickListener(this);
        drop_out = findViewById(R.id.drop_out);
        drop_out.setOnClickListener(this);
    }
    public void initData(){

    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
            case R.id.ib_send_feeling_content:
                Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.drop_out:


                ActivityController.clearActivty();
                Intent intent = new Intent(this, LoginActivity.class);
                String userPhone = "Homy";
                String passWord = "Homy";
                UserManage.getInstance().saveUserInfo(this,userPhone,passWord);
                startActivity(intent);
                finish();
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

    @Override
    public void initDemand(List<PersonBean> demandBeanList) {

    }

    @Override
    public void initOrder(List<PersonBean> orderBeanList) {

    }
}
