package com.bojue.homy.view.fragment.person;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.presenter.person.AbstractPersonPresenter;
import com.bojue.homy.presenter.person.PersonTest;
import com.bojue.homy.view.activity.person.AboutUsActivity;
import com.bojue.homy.view.activity.person.demand.MyDemandActivity;
import com.bojue.homy.view.activity.person.message.MessageActivity;
import com.bojue.homy.view.activity.person.order.MyOrderActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 * 个人中心Fragment
 */

public class PersonFragment extends BaseFragment implements IPersonView,View.OnClickListener{

    private View mView;
    private ImageButton next_order;
    private ImageButton next_demand;
    private ImageButton next_about_us;
    private Button write_person_msg;
    private ImageView img_user_pic;
    private LinearLayout orderLinearLayout;
    private LinearLayout demandLinearLayout;
    private LinearLayout aboutLinearLayout;

    private AbstractPersonPresenter mPresenter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        mView = View.inflate(getContext(),R.layout.fragement_person,null);
        next_order = mView.findViewById(R.id.next_order);
        next_demand = mView.findViewById(R.id.next_demand);
        next_about_us = mView.findViewById(R.id.next_about_us);
        write_person_msg = mView.findViewById(R.id.write_person_msg);
        img_user_pic = mView.findViewById(R.id.img_user_pic);

        orderLinearLayout=mView.findViewById(R.id.ts_order);
        demandLinearLayout=mView.findViewById(R.id.ts_demand);
        aboutLinearLayout=mView.findViewById(R.id.ts_about_us);

        return mView;
    }

    public void initData() {

        orderLinearLayout.setOnClickListener(this);
        demandLinearLayout.setOnClickListener(this);
        aboutLinearLayout.setOnClickListener(this);
        write_person_msg.setOnClickListener(this);
        img_user_pic.setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ts_order:
                Toast.makeText(getContext(),"我的订单",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MyOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.ts_demand:
                Toast.makeText(getContext(),"我的需求",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(getContext(), MyDemandActivity.class);
                startActivity(intent2);
                break;
            case R.id.ts_about_us:
                Toast.makeText(getContext(),"关于我们",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(getActivity(), AboutUsActivity.class);
                startActivity(intent3);
                break;
            case R.id.write_person_msg:
                Toast.makeText(getContext(),"编辑个人信息",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(getContext(), MessageActivity.class);
                startActivity(intent4);
                break;
            case R.id.img_user_pic:
                Toast.makeText(getContext(),"图片",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
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

}
