package com.bojue.homy.view.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.presenter.community.AbstractCommunityPresenter;
import com.bojue.homy.presenter.community.ComPre;
import com.bojue.homy.view.fragment.community.ICommunityView;
import com.bumptech.glide.Glide;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.impl.AlbumImageLoader;

import java.io.File;
import java.util.ArrayList;
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
    private AbstractCommunityPresenter mCommunityPresenter;
    private ArrayList<String> mImageList;
    private ImageView iv_public_feeling;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 666) {
            if (resultCode == RESULT_OK) { // Successfully.
                //将图片显示到

                ArrayList<String> pathList = Album.parseResult(data);
                imagUrl = pathList.get(0);
               Bitmap bitmap = BitmapFactory.decodeFile(imagUrl);
                iv_public_feeling.setImageBitmap(bitmap);
            } else if (resultCode == RESULT_CANCELED) { // User canceled.
                // 用户取消了操作。
            }
        }
    }

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
        iv_public_feeling = findViewById(R.id.iv_public_feeling);

    }
    //数据处理
    private void initData() {
        ib_back_community.setOnClickListener(this);
        ib_feeling_picture.setOnClickListener(this);
        ib_send_feeling_content.setOnClickListener(this);
        mDate = getSystemDate();
        mCommunityPresenter = new ComPre();
        mCommunityPresenter.attachView(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
            case R.id.ib_feeling_picture:
                Album.album(this)
                        .requestCode(666)
                        .toolBarColor(getResources().getColor(R.color.colorBackgroundLine))
                        .title("图库")
                        .selectCount(1)
                        .columnCount(3)
                        .camera(true)
                        .checkedList(mImageList)
                        .start();

                break;
            case R.id.ib_send_feeling_content:
                feelingContent = et_feeling_publish.getText().toString();
                if(TextUtils.isEmpty(feelingContent)){
                    et_feeling_publish.setError("内容不能为空");
                }else {
                    mCommunityPresenter.submitCommunityFeeling(uId, imagUrl, feelingContent, mDate);
                }
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
        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setTitle("提交成功!")
                .setMessage("快去社区列表看看你的心情吧！");
        dialog.show();
        et_feeling_publish.setText("");
        iv_public_feeling.setImageBitmap(null);
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

    /**
     * 用Glide实现：
     */
    public class GlideImageLoader implements AlbumImageLoader {
        @Override
        public void loadImage(ImageView imageView, String imagePath, int width, int height) {
            Glide.with(imageView.getContext())
                    .load(new File(imagePath))
                    .into(imageView);
        }
    }
}
