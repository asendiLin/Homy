package com.bojue.homy.view.pager;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BasePager;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.presenter.person.AbstractPersonPresenter;
import com.bojue.homy.presenter.person.PersonPresenter;
import com.bojue.homy.presenter.person.PersonTest;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.adapter.OrderItemAdapter;
import com.bojue.homy.view.fragment.person.IPersonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xie on 2018/1/8.
 * 我的订单之RecyclerView
 */

public class OrderPager extends BasePager implements IPersonView,LoadDataScrollController.OnRecyclerRefreshListener{
    private List<PersonBean> mPersonList;
    private OrderItemAdapter mAdapter;//item适配器

    private RecyclerView mRecyclerView;
    private AbstractPersonPresenter mPresenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ViewStub mViewStub;
    private View errView;

    private int page= 1;//接后台，每次加载列表的页数
    private LoadDataScrollController mLoadDataScrollController;


    public OrderPager(Context context) {
        super(context);
    }

    public View initView(){
        View view = View.inflate(context,R.layout.activity_my_order_recyclerview,null);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout= view.findViewById(R.id.refreshLayout);
        mViewStub = view.findViewById(R.id.view_stub_err);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false);
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

    public void initData(){
        mPersonList = new ArrayList<>();
        //设置RecyclerView的适配器
        mAdapter = new OrderItemAdapter(context,mPersonList);
        mRecyclerView.setAdapter(mAdapter);
        mPresenter=new PersonTest();
        //mPresenter = new PersonPresenter();
        //获取当前view的实例
        mPresenter.attachView(this);
        mPresenter.loadOrder(page);

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

    /**
     * 初始化需求数据
     */
    @Override
    public void initDemand(List<PersonBean> damandBeanList) {
    }

    /**
     * 初始化订单数据
     * @param orderBeanList
     */
    @Override
    public void initOrder(List<PersonBean> orderBeanList) {
        if(page == 1){
            mPersonList.clear();
        }
        this.mPersonList.addAll(orderBeanList);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        page = 1;
        mPresenter.loadOrder(page);
        mLoadDataScrollController.setLoadDataStatus(false);//是否正在下载数据
        mSwipeRefreshLayout.setRefreshing(false);//是否正在刷新
    }

    /**
     * 加载更多
     */
    @Override
    public void onLoadMore() {
        ++page;
        mPresenter.loadOrder(page);
        mLoadDataScrollController.setLoadDataStatus(false);
    }
}
