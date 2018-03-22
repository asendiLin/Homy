package com.bojue.homy.view.pager;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;

import com.bojue.homy.R;
import com.bojue.homy.base.BasePager;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.presenter.person.AbstractPersonPresenter;
import com.bojue.homy.presenter.person.PersonTest;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.adapter.DemandItemAdapter;
import com.bojue.homy.view.fragment.person.IPersonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2018/3/21.
 */

public class DemandPager extends BasePager implements IPersonView,LoadDataScrollController.OnRecyclerRefreshListener {

    private RecyclerView mRecyclerView;
    private DemandItemAdapter mAdapter;
    private   List<PersonBean> mPersonList;
    private SwipeRefreshLayout mSwipeRefreshLayout;//设置下拉刷新和加载更多
    private LoadDataScrollController mLoadDataScrollController;
    private int page;
    private AbstractPersonPresenter mPresenter;
    private ViewStub mViewStub;
    private View errView;

    public DemandPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_my_demand_recyclerview,null);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mViewStub = view.findViewById(R.id.view_stub_err);
        mSwipeRefreshLayout= view.findViewById(R.id.refreshLayout);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayout.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置下拉刷新和加载更多
        mLoadDataScrollController=new LoadDataScrollController(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBackgroundLine);
        mSwipeRefreshLayout.setProgressViewOffset(true,0,10);
        mRecyclerView.addOnScrollListener(mLoadDataScrollController);
        mSwipeRefreshLayout.setOnRefreshListener(mLoadDataScrollController);

        initData();
        return view;
    }

    public void initData() {
        mPersonList = new ArrayList<>();
        mAdapter = new DemandItemAdapter(context,mPersonList);
        mRecyclerView.setAdapter(mAdapter);

        mPresenter = new PersonTest();
        mPresenter.attachView(this);
        mPresenter.loadDemand(page);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {
        if (!isSuccess) {
            mSwipeRefreshLayout.setVisibility(View.GONE);

            if (errView==null){//显示错误界面
                errView = mViewStub.inflate();
                Button reloadBtn = errView.findViewById(R.id.btn_err);
                reloadBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //toDo:reload data.

                    }
                });
            }
        }else {
            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
            if (errView!=null)
                errView.setVisibility(View.GONE);
        }

        mLoadDataScrollController.setLoadDataStatus(false);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void initDemand(List<PersonBean> demandBeanList) {
        if(page == 1){
            mPersonList.clear();
        }
        this.mPersonList.addAll(mPersonList);
        mAdapter.notifyDataSetChanged();

    }

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
