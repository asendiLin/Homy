package com.bojue.homy.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.presenter.community.CommunityPresenter;
import com.bojue.homy.view.fragment.community.ICommunityView;

import java.util.List;

import static com.bojue.homy.utils.https.date.DateUtil.getSystemDate;

public class PublishFeelingActivity extends BaseActivity implements ICommunityView, View.OnClickListener{
    private ImageButton ib_back_community;
    private Button ib_send_feeling_content;
    private ImageButton ib_feeling_picture;
    private EditText et_feeling_publish;
    private int uId=1;
    private String imagUrl = "";
    private String feelingContent = "";
    private String mDate;
    private CommunityPresenter mCommunityPresenter;

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
        ib_send_feeling_content.setOnClickListener(this);
        mDate = getSystemDate();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
            case R.id.ib_feeling_picture:

                break;
            case R.id.ib_send_feeling_content:
                mCommunityPresenter.submitCommunityFeeling(uId,imagUrl,feelingContent,mDate);
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

    @Override
    public void initCommunity(List<CommunityBean> communityBeanList) {

    }
    //提交心情成功的回调
    @Override
    public void sendSuccess() {

    }
    //提交心情失败的回调
    @Override
    public void sendFail() {

    }


    @Override
    public void thumbUpSuccess(int position) {

    }

    @Override
    public void thumbUpFail() {

    }
}
