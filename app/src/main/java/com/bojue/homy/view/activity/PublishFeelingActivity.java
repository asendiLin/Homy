package com.bojue.homy.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.view.IView;

public class PublishFeelingActivity extends BaseActivity implements PublishFeelingView, View.OnClickListener{
    private ImageButton ib_back_community;
    private Button ib_send_feeling_content;
    private ImageButton ib_feeling_picture;
    private EditText et_feeling_publish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_feeling);
        initView();
        initData();
    }
    //初始化视图
    private void initView() {
        ib_back_community = findViewById(R.id.ib_back_community);
        ib_send_feeling_content = findViewById(R.id.ib_send_feeling_content);
        ib_back_community.setVisibility(View.VISIBLE);
        ib_send_feeling_content.setVisibility(View.VISIBLE);
        ib_feeling_picture = findViewById(R.id.ib_feeling_picture);
        et_feeling_publish = findViewById(R.id.et_feeling_publish);

    }
    //数据处理
    private void initData() {
        ib_back_community.setOnClickListener(this);
        ib_feeling_picture.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
            case R.id.ib_feeling_picture:

                break;
            default:
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
}
