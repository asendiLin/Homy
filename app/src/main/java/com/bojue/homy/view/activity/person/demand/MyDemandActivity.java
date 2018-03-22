package com.bojue.homy.view.activity.person.demand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.presenter.person.AbstractPersonPresenter;
import com.bojue.homy.presenter.person.PersonTest;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.activity.person.order.MyOrderActivity;
import com.bojue.homy.view.adapter.DemandAdapter;
import com.bojue.homy.view.adapter.DemandItemAdapter;
import com.bojue.homy.view.fragment.person.IPersonView;
import com.bojue.homy.view.pager.DemanPager;
import com.bojue.homy.view.pager.DemandPager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2018/1/8.
 * 我的需求之activity
 */

public class MyDemandActivity extends BaseActivity  implements IPersonView,View.OnClickListener{
    private final String TAG=this.getClass().getName();
    private TabLayout mTablayout;
    private ImageButton ib_back_community;//返回按钮
    private List<DemanPager> mPersonList;
    public DemandAdapter mAdapter;//RecyclerView的适配器
    private RecyclerView mRecyclerView;
    private ViewPager view_pager;
    private AbstractPersonPresenter mPresenter;
    private int tempPositon = 0 ;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_demand);
        initView();
        initData();
    }

    public void initView(){
        ib_back_community = findViewById(R.id.ib_back_community);
        ib_back_community.setVisibility(View.VISIBLE);
        ib_back_community.setOnClickListener(this);
        mTablayout = findViewById(R.id.tablayout);
        view_pager = findViewById(R.id.view_pager);

    }

    public void initData(){
        mPersonList = new ArrayList<>();
        //设置ViewPager的适配器
        DemanPager demandPager = new DemanPager(this);
        mPersonList.add(demandPager);
        DemanPager demandPager2 = new DemanPager(this);
        mPersonList.add(demandPager2);
        DemanPager demandPager3 = new DemanPager(this);
        mPersonList.add(demandPager3);
        DemanPager demandPager4 = new DemanPager(this);
        mPersonList.add(demandPager4);
        mAdapter = new DemandAdapter(mPersonList);

//        mAdapter.setItemListener(new DemandItemAdapter.onItemClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                Log.i(TAG, "onClick: "+position);
//            }
//        });
        view_pager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(view_pager);
        reflex(mTablayout);
        setTabView();
        view_pager.setCurrentItem(tempPositon);


    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
        }
    }

    public void setTabView() {
        for (int i=0;i<mTablayout.getTabCount();i++){
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(mAdapter.getTabView(i,this));
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
            int dp10 = MyOrderActivity.DensityUtil.dip2px(tabLayout.getContext(),7);//一直实现不了的假象：距离太小
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

    /**
     * 初始化需求数据
     */
    @Override
    public void initDemand(List<PersonBean> damandBeanList) {
//        if( page == 1){
//            mPersonList.clear();
//        }
//        this.mPersonList.addAll(damandBeanList);
//        mAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化订单数据
     * @param orderBeanList
     */
    @Override
    public void initOrder(List<PersonBean> orderBeanList) {

    }






}
