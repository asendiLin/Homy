package com.bojue.homy.view.activity.land_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;

/**
 * Created by Xie on 2018/1/15.
 * 注册界面
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener{

    private Button register;//注册按钮
    private TextView txt_title;//标题

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        initView();
        initData();
    }

    public void initView(){
        register = findViewById(R.id.register);
        txt_title = findViewById(R.id.txt_title);
    }
    public void initData(){
        txt_title.setText("注册");
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,LoginActivity.class);
        //清除TaskStack，再创建一个新的,移除栈里面的活动，返回键只剩下LoginActivity
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
