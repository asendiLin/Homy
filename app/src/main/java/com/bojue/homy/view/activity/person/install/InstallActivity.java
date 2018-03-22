package com.bojue.homy.view.activity.person.install;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.utils.https.activity.ActivityController;
import com.bojue.homy.view.activity.land_register.LoginActivity;
import com.bojue.homy.view.activity.land_register.UserManage;

/**
 * Created by Xie on 2018/3/20.
 */

public class InstallActivity extends BaseActivity implements View.OnClickListener{

    private Button btn_drop_out;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_install);
        initView();
        initData();
    }

    public void initView() {
        btn_drop_out = findViewById(R.id.btn_drop_out);
    }

    public void initData() {
        btn_drop_out.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn_drop_out:
                ActivityController.clearActivty();
                Intent intent = new Intent(this, LoginActivity.class);
                //清除TaskStack，再创建一个新的,实现注销之后，返回键不能返回
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                String userPhone = "Homy";
                String passWord = "Homy";
                UserManage.getInstance().saveUserInfo(this,userPhone,passWord);
                startActivity(intent);
                finish();

                Log.i("TAG","ssss");
                break;

            default:
                break;
        }
    }
}
