package com.bojue.homy.view.pager;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

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
    private int page= 1;//接后台，每次加载列表的页数
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private LoadDataScrollController mLoadDataScrollController;


    public OrderPager(Context context) {
        super(context);
    }

    public View initView(){
        View view = View.inflate(context,R.layout.activity_my_order_recyclerview,null);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout= view.findViewById(R.id.refreshLayout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context) {
            /**
             * 解决子布局item不能铺满父布局
             * @return
             */
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);//width,height
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);//设置父布局的排列方式
        mRecyclerView.setLayoutManager(layoutManager);
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
