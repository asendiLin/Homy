package com.bojue.homy.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.view.pager.DemanPager;
import com.bojue.homy.view.pager.DemandPager;

import java.util.List;

/**
 * Created by Xie on 2018/3/21.
 */

public class DemandAdapter extends PagerAdapter {

    private final List<DemanPager> mList;
    private String[] mTitles = {"等待","取消","进行中","完成"};

    public DemandAdapter(List<DemanPager> mList) {
        this.mList = mList;
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
        DemanPager demandPager = mList.get(position);
        View rootView = demandPager.rootView;
        demandPager.initData();
        container.addView(rootView);
        return rootView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
    public View getTabView(int position, Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tablayout_item,null);
        TextView textView = view.findViewById(R.id.textView);
        textView.setText(mTitles[position]);
        return view;
    }

}
