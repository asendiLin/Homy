package com.bojue.homy.view.fragment.find;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.entity.NeedItem;
import com.bojue.homy.listener.OnItemListener;
import com.bojue.homy.presenter.find.AbstractFindNeedPresenter;
import com.bojue.homy.presenter.find.FindNeedPresenter;
import com.bojue.homy.presenter.find.FindNeedPresenterText;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.activity.find.NeedDetailActivity;
import com.bojue.homy.view.adapter.FindNeedAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */

public class FindNeedFragment extends BaseFragment implements IFindNeedView,
        LoadDataScrollController.OnRecyclerRefreshListener, View.OnClickListener {

    private View mView;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ViewStub mViewStub;
    private View errView;
    private Dialog mBottomDialog;

    private LoadDataScrollController mLoadDataScrollController;
    private List<NeedItem> mNeedItems;
    private int page = 1;
    private AbstractFindNeedPresenter mPresenter;
    private FindNeedAdapter mAdapter;


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.fragment_need_layout, container, false);
        mRecyclerView = mView.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = mView.findViewById(R.id.refreshLayout);
        mViewStub = mView.findViewById(R.id.view_stub_err);

        getActivity().findViewById(R.id.ib_filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "筛选", Toast.LENGTH_SHORT).show();

                View dialogContentView = View.inflate(getActivity(),
                        R.layout.dialog_bottom_filter, null);


                mBottomDialog = new Dialog(getActivity(), R.style.dialog_bottom_filter);
                mBottomDialog.setContentView(dialogContentView);
                mBottomDialog.setCanceledOnTouchOutside(true);

                Window window = mBottomDialog.getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.y = 10;//设置距离底部距离
                lp.width = LinearLayout.LayoutParams.MATCH_PARENT;
                lp.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                window.setAttributes(lp);
                window.setGravity(Gravity.BOTTOM);
                mBottomDialog.show();
            }
        });

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBackgroundLine);

        mSwipeRefreshLayout.setProgressViewOffset(true, 0, 10);
        return mView;
    }

    @Override
    public void initData() {
        super.initData();
        mLoadDataScrollController = new LoadDataScrollController(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addOnScrollListener(mLoadDataScrollController);
        mSwipeRefreshLayout.setOnRefreshListener(mLoadDataScrollController);
        mNeedItems = new ArrayList<>();
        //toDo:loadData
//        mPresenter=new FindNeedPresenter();
//        mPresenter.attachView(this);
//        mPresenter.loadNeed("type","uId",page);

        //设置适配器
        mAdapter = new FindNeedAdapter(mNeedItems, getContext());
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setListener(new OnItemListener() {
            @Override
            public void onClick(View view, int position) {
                //toDo:传递条目的ID到Activity
                startActivity(new Intent(getActivity(), NeedDetailActivity.class));
            }
        });

        mPresenter = new FindNeedPresenterText();
        mPresenter.attachView(this);
        mPresenter.loadNeed("type", "uId", page);
    }

    /**
     * 加载刷新
     *
     * @param needItems
     */
    @Override
    public void showNeedItems(List<NeedItem> needItems) {
        if (page == 1) {//刷新操作
            mNeedItems.clear();
        }
        mNeedItems.addAll(needItems);
        mAdapter.notifyDataSetChanged();


        //toDo:refresh the layout
    }

    @Override
    public void onRefresh() {
        page = 1;
        //toDo:loadData
        mPresenter.loadNeed("type", "uId", page);

    }

    @Override
    public void onLoadMore() {
        ++page;
        //toDo:load more data
        mPresenter.loadNeed("type", "uId", page);
    }

    @Override
    public void showLoading() {
        mLoadDataScrollController.setLoadDataStatus(true);
        mSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading(boolean isSuccess) {

        if (!isSuccess) {
            mSwipeRefreshLayout.setVisibility(View.GONE);

            if (errView == null) {
                errView = mViewStub.inflate();
                Button reloadBtn = errView.findViewById(R.id.btn_err);
                reloadBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //toDo:reload data.
                        mPresenter.loadNeed("1", "2", 3);
                        Toast.makeText(getActivity(), "reload!!!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } else {
            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
            if (errView != null)
                errView.setVisibility(View.GONE);
        }

        mLoadDataScrollController.setLoadDataStatus(false);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm://确认
                break;
        }
    }
}
