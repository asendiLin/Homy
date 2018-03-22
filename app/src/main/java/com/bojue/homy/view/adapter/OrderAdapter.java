package com.bojue.homy.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.view.pager.OrderPager;

import java.util.List;

/**
 * Created by Xie on 2018/1/12.
 * 我的订单之ViewPager适配器
 */

public class OrderAdapter extends PagerAdapter {

    private final List<OrderPager> mList;
    private String[] mTitles = {"等待","取消","进行中","完成","过期"};

    public OrderAdapter(List<OrderPager>  list){
        this.mList =  list;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        OrderPager myOrderPager = mList.get(position);
        View rootView = myOrderPager.rootView;
        myOrderPager.initData();//初始化数据
        container.addView(rootView);
        return rootView;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //container.removeView( mList.get(position));
        container.removeView((View) object);
    }

    public View getTabView(int position, Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tablayout_item, null);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(mTitles[position]);
        return view;
    }
}
