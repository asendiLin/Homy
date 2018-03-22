package com.bojue.homy.view.activity.person.order;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.adapter.OrderAdapter;
import com.bojue.homy.view.fragment.person.IPersonView;
import com.bojue.homy.view.pager.OrderPager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2018/1/8.
 * 我的订单界面
 */

public class MyOrderActivity extends BaseActivity implements IPersonView,View.OnClickListener {

    private OrderAdapter mAdapter; //ViewPager的适配器
    private TabLayout mTablayout;
    private ViewPager mViewPager; // 对应的viewPager
    private TextView txt_title; //标题
    private int tempPositon = 0 ;
    private ImageButton ib_back_community;//回退键
    private ArrayList<OrderPager> mUnFinishPager;//未完成的页面
    private ArrayList<OrderPager> mFinishPager;//已完成的页面


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        initView();
        initData();
    }

    public void initView(){
        mViewPager = findViewById(R.id.viewPager);
        mTablayout = findViewById(R.id.tablayout);
        txt_title = findViewById(R.id.txt_title);
        ib_back_community = findViewById(R.id.ib_back_community);


    }

    public void initData(){
        ib_back_community.setVisibility(View.VISIBLE);
        ib_back_community.setOnClickListener(this);
        txt_title.setText("我的订单");

       //设置RecyclerView的数组
        mUnFinishPager = new ArrayList<>();
        OrderPager basePager = new OrderPager(this);
        mUnFinishPager.add(basePager);
        OrderPager basePager2 = new OrderPager(this);
        mUnFinishPager.add(basePager2);
        OrderPager basePager3 = new OrderPager(this);
        mUnFinishPager.add(basePager3);
        OrderPager basePager4 = new OrderPager(this);
        mUnFinishPager.add(basePager4);
        OrderPager basePager5 = new OrderPager(this);
        mUnFinishPager.add(basePager5);
        //设置ViewPager的适配器
        mAdapter = new OrderAdapter(mUnFinishPager);
        mViewPager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewPager);//绑定ViewPager
        reflex(mTablayout);//修改tabIndicator
        setTabView();//自定义TabLayout
        mViewPager.setCurrentItem(tempPositon);


    }

    public void onClick(View view){
        finish();
    }

    public void setTabView(){
        //设置TabLayout的自定义View
        for (int i = 0; i <mTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);   //遍历所有TabCount
//            tab.setCustomView(R.layout.tablayout_item);//CustomView:自定义View
//            mTextView = findViewById(R.id.textView);
            if (tab != null) {
                tab.setCustomView(mAdapter.getTabView(i,this));//CustomView:自定义View
            }
            }
        }


    /**
     * 修改tabIndicator，使其与文字对齐
     * 反射原理：先得到TabLayout的Class对象，然后得到私有成员变量mSlidingTabStrip的Field，通过Field得到值强转为LinearLayout，之后只需要遍历LinearLayout中所有的Child为其增加Margin即可
     * @param tabLayout
     */
    public static void reflex(final TabLayout tabLayout) {
        try {
            Field tabStrip = tabLayout.getClass().getDeclaredField("mTabStrip");
            tabStrip.setAccessible(true);
            LinearLayout ll_tab = (LinearLayout) tabStrip.get(tabLayout);
            int dp10 = DensityUtil.dip2px(tabLayout.getContext(),7);//一直实现不了的假象：距离太小
            for (int i = 0; i < ll_tab.getChildCount(); i++) {
                View child = ll_tab.getChildAt(i);
                child.setPadding(0, 0, 0, 0);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                params.leftMargin = dp10;//这里需要修改
                params.rightMargin = dp10;
                child.setLayoutParams(params);
                child.invalidate();
            }
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }

    @Override
    public void initDemand(List<PersonBean> demandBeanList) {

    }


    @Override
    public void initOrder(List<PersonBean> orderBeanList) {

    }

    /**
     * 像素和dp的转换
     */
    public static class DensityUtil {
        /**
         * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
         */
        public  static int dip2px(Context context, float dpValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        }

        /**
         * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
         */
        public  static int px2dip(Context context, float pxValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (pxValue / scale + 0.5f);
        }
    }

}
