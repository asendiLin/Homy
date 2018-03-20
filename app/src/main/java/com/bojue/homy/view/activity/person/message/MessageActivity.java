package com.bojue.homy.view.activity.person.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.utils.https.activity.ActivityController;
import com.bojue.homy.presenter.person.MessagePresenter;
import com.bojue.homy.view.activity.land_register.LoginActivity;
import com.bojue.homy.view.activity.land_register.UserManage;
import com.bojue.homy.view.activity.person.demand.MyDemandView;
import com.bojue.homy.view.fragment.person.IPersonView;
import com.bojue.homy.view.fragment.person.PersonFragment;

import java.util.List;

/**
 * Created by Xie on 2018/1/12.
 * 编辑个人信息界面
 * 1.昵称
 * 2.性别
 * 3.退出登录
 */

public class MessageActivity extends BaseActivity implements MessageView,View.OnClickListener {

    private ImageButton ib_back_community;//返回按钮
    private Button ib_send_feeling_content;//发送按钮
    private Button drop_out;//退出登录
    private SharedPreferences mSharedPreferences;
    private ArrayAdapter<String> mAdapter;//spinner的适配器
    private EditText et_name_msg;//用户昵称
    private String mName = "";
    private RadioGroup rd_msg;//性别选择框
    private RadioButton rb_male;
    private RadioButton rb_female;
    private String gender = null;//获取用户性别
    private int sex=1;
    private MessagePresenter mMessagePresenter;

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
        et_name_msg = findViewById(R.id.et_name_msg);
        rd_msg = findViewById(R.id.rd_msg);
        rb_male = findViewById(R.id.rb_male);
        rb_female = findViewById(R.id.rb_female);


    }
    public void initData(){

        rd_msg.setOnCheckedChangeListener(new mOnCheckedChangeListener());
        mMessagePresenter = new MessagePresenter();
        mMessagePresenter.attachView(MessageActivity.this);


    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
            case R.id.ib_send_feeling_content:
                String name = et_name_msg.getText().toString();
                String mId="93f176fa-5e8e-41ad-ab7b-ab49b1a0e3fb";


                mMessagePresenter.submitMessageContent(name,sex,mId);

                mName = et_name_msg.getText().toString();
                Intent intent2 = new Intent();
                intent2.putExtra("mName",mName);
                intent2.putExtra("gender",gender);
                intent2.setAction("MessageActivity");
                BroadCastManger.getInstance().sendBroadCast(this,intent2);
                finish();

                break;
            case R.id.drop_out:


                ActivityController.clearActivty();
                Intent intent = new Intent(this, LoginActivity.class);
                //清除TaskStack，再创建一个新的,实现注销之后，返回键不能返回
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
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
    public void submitMessageContent() {
        Log.i("TAG","修改成功");

    }
    public class mOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{
       @Override
       public void onCheckedChanged(RadioGroup group, int checkedId) {
           if (MessageActivity.this.rb_male.getId() == checkedId) {
               gender = MessageActivity.this.rb_male.getText().toString();
               sex = 1;
           }
           if (MessageActivity.this.rb_female.getId() == checkedId) {
               gender = MessageActivity.this.rb_female.getText().toString();
               sex = 0;
           }
            Log.i("TAG","选择成功"+gender);
       }
   }
}
