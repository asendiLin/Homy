package com.bojue.homy.view.activity.find;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.NeedDetailBean;

//需求详情Activity
public class NeedDetailActivity extends BaseActivity implements INeedDetailView, View.OnClickListener {

    private ImageButton imgBtnBack;
    private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_detail);

        initView();

    }

    @Override
    protected void onStart() {
        super.onStart();
        //toDo:显示数据
    }

    private void initView() {
        imgBtnBack = findViewById(R.id.ib_back_community);
        imgBtnBack.setVisibility(View.VISIBLE);
        imgBtnBack.setOnClickListener(this);
        btnAccept = findViewById(R.id.btn_accept);
        btnAccept.setOnClickListener(this);
    }

    /**
     * 显示需求详情
     *
     * @param needDetailBean
     */
    @Override
    public void showNeedDetail(NeedDetailBean needDetailBean) {

    }

    /**
     * 接单结果
     *
     * @param isSuccess
     */
    @Override
    public void showAcceptResult(boolean isSuccess) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_back_community://返回
                finish();
                break;
            case R.id.btn_accept:
                Toast.makeText(this, "接单", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
