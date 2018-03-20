package com.bojue.homy.view.activity.person.demand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.presenter.person.AbstractPersonPresenter;
import com.bojue.homy.presenter.person.PersonPresenter;
import com.bojue.homy.presenter.person.PersonTest;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.adapter.DemandAdapter;
import com.bojue.homy.view.fragment.person.IPersonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2018/1/8.
 * 我的需求之activity
 */

public class MyDemandActivity extends BaseActivity  implements IPersonView,View.OnClickListener,LoadDataScrollController.OnRecyclerRefreshListener{
    private final String TAG=this.getClass().getName();
    private ImageButton ib_back_community;//返回按钮
    private List<PersonBean> mPersonList;
    public DemandAdapter mAdapter;//RecyclerView的适配器
    private RecyclerView mRecyclerView;
    private AbstractPersonPresenter mPresenter;
    private int page= 1;//后台传过来的item数目
    private SwipeRefreshLayout mSwipeRefreshLayout;//设置下拉刷新和加载更多
    private LoadDataScrollController mLoadDataScrollController;
    @Override
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
        mRecyclerView = findViewById(R.id.recyclerView);
        mSwipeRefreshLayout= findViewById(R.id.refreshLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置下拉刷新和加载更多
        mLoadDataScrollController=new LoadDataScrollController(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBackgroundLine);
        mSwipeRefreshLayout.setProgressViewOffset(true,0,10);
        mRecyclerView.addOnScrollListener(mLoadDataScrollController);
        mSwipeRefreshLayout.setOnRefreshListener(mLoadDataScrollController);
    }

    public void initData(){
        mPersonList = new ArrayList<>();
        //设置RecyclyerView的适配器
        mAdapter = new DemandAdapter(mPersonList);
        mAdapter.setItemListener(new DemandAdapter.onItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.i(TAG, "onClick: "+position);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mPresenter = new PersonTest();
        //mPresenter = new PersonPresenter();
        //获取当前view的实例
        mPresenter.attachView(this);
        mPresenter.loadDemand(page);

    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
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
        if( page == 1){
            mPersonList.clear();
        }
        this.mPersonList.addAll(damandBeanList);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化订单数据
     * @param orderBeanList
     */
    @Override
    public void initOrder(List<PersonBean> orderBeanList) {

    }





    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        page = 1;
        mPresenter.loadDemand(page);
        mLoadDataScrollController.setLoadDataStatus(false);//是否正在下载数据
        mSwipeRefreshLayout.setRefreshing(false);//是否正在刷新
    }
    //加载更多
    @Override
    public void onLoadMore() {
        ++page;
        mPresenter.loadDemand(page);
        mLoadDataScrollController.setLoadDataStatus(false);
    }
}
