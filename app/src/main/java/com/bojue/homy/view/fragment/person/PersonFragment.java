package com.bojue.homy.view.fragment.person;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.presenter.person.AbstractImagePresenter;
import com.bojue.homy.presenter.person.AbstractPersonPresenter;
import com.bojue.homy.presenter.person.ImagePresenter;
import com.bojue.homy.view.activity.person.AboutUsActivity;
import com.bojue.homy.view.activity.person.demand.MyDemandActivity;
import com.bojue.homy.view.activity.person.install.InstallActivity;
import com.bojue.homy.view.activity.person.message.BroadCastManger;
import com.bojue.homy.view.activity.person.message.MessageActivity;
import com.bojue.homy.view.activity.person.order.MyOrderActivity;
import com.bojue.homy.view.activity.person.phone.MyPhoneActivity;
import com.bumptech.glide.Glide;
import com.yanzhenjie.album.Album;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/1/6.
 * 个人中心Fragment
 */

public class PersonFragment extends BaseFragment implements IPersonView, View.OnClickListener, com.bojue.homy.view.activity.person.ImageView {

    private View mView;
    private ImageButton next_order;
    private ImageButton next_demand;
    private ImageButton next_about_us;
    private ImageButton next_my_phone;
    private ImageView img_user_pic;
    private LinearLayout orderLinearLayout;
    private LinearLayout demandLinearLayout;
    private LinearLayout installLinearLayout;
    private LinearLayout personMsgLinearLayout;

    private AbstractPersonPresenter mPresenter;
    private AbstractImagePresenter mIamegPresenter;
    private TextView ts_name_person;
    private String imagUrl = "";
    private ArrayList<String> mImageList;
    private static final int RESULT_OK = -1;
    private static final int mRequestCode = 66;
    private LocalReceiver localReceiver;
    private String name = "名字";
    private String sex= "man";


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        mView = View.inflate(getContext(), R.layout.fragement_person, null);
        next_order = mView.findViewById(R.id.next_order);
        next_demand = mView.findViewById(R.id.next_demand);
        next_my_phone = mView.findViewById(R.id.next_my_phone);
        next_about_us = mView.findViewById(R.id.next_about_us);
        img_user_pic = mView.findViewById(R.id.img_user_pic);
        ts_name_person = mView.findViewById(R.id.ts_name_person);


        orderLinearLayout = mView.findViewById(R.id.ts_order);
        demandLinearLayout = mView.findViewById(R.id.ts_demand);
        installLinearLayout = mView.findViewById(R.id.ts_install);
        personMsgLinearLayout = mView.findViewById(R.id.ts_msg_person);

        return mView;
    }

    public void initData() {

        orderLinearLayout.setOnClickListener(this);
        demandLinearLayout.setOnClickListener(this);
        installLinearLayout.setOnClickListener(this);
        personMsgLinearLayout.setOnClickListener(this);

        next_my_phone.setOnClickListener(this);
        img_user_pic.setOnClickListener(this);

        mIamegPresenter = new ImagePresenter();
        mIamegPresenter.attachView(this);

        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction("MessageActivity");
            localReceiver = new LocalReceiver();
            Log.i("TAG","这是名字"+name);
            ts_name_person.setText(name);
            BroadCastManger.getInstance().registerReceiver(getActivity(),localReceiver,filter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ts_order:
                Toast.makeText(getContext(), "我的订单", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.ts_demand:
                Toast.makeText(getContext(), "我的需求", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getContext(), MyDemandActivity.class);
                startActivity(intent2);
                break;
            case R.id.ts_msg_person:
                Toast.makeText(getContext(), "编辑个人信息", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(getContext(), MessageActivity.class);
                startActivity(intent4);
                break;
            case R.id.img_user_pic:
                Album.album(this)
                        .requestCode(mRequestCode)
                        .toolBarColor(getResources().getColor(R.color.colorBackgroundLine))
                        .title("图库")
                        .selectCount(1)
                        .columnCount(3)
                        .camera(true)
                        .checkedList(mImageList)
                        .start();
                break;
            case R.id.ts_install:
                Intent intent5 = new Intent(getActivity(), InstallActivity.class);
                startActivity(intent5);

                break;
            default:
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String mId = "93f176fa-5e8e-41ad-ab7b-ab49b1a0e3fb";
        if (requestCode == mRequestCode) {
            if (resultCode == RESULT_OK) {
                List<MultipartBody.Part> part = null; // Parse path.
                ArrayList<String> pathList = Album.parseResult(data);
                imagUrl = pathList.get(0);
                File file = new File(imagUrl);
                MultipartBody.Builder builder = new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("userId", mId);
                RequestBody imgBody = RequestBody.create(MediaType.parse("multpart/form-data"), file);
                builder.addFormDataPart("file", file.getName(), imgBody);
                part = builder.build().parts();

                Log.i("TAG", "onActivityResult: " + part);
                mIamegPresenter.submitImage(part);

            }
        }
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            name = intent.getStringExtra("mName");
            sex = intent.getStringExtra("gender");
            Toast.makeText(context, "Sucess:"+name+sex, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showImage(String path) {
        Glide.with(this)
                .load(path)
                .into(img_user_pic);
        Toast.makeText(getContext(), "修改头像成功", Toast.LENGTH_SHORT).show();
    }
    /**
     * 初始化需求列表
     * @param demandBeanList
     */
    @Override
    public void initDemand(List<PersonBean> demandBeanList) {

    }
    /**
     * 初始化订单列表
     *
     * @param orderBeanList
     */
    @Override
    public void initOrder(List<PersonBean> orderBeanList) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BroadCastManger.getInstance().unregisterReceiver(getActivity(),localReceiver);
    }

}
