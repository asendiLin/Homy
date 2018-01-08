package com.bojue.homy.view.fragment.community;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.presenter.community.AbstractCommunityPresenter;
import com.bojue.homy.presenter.community.ComPre;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.adapter.CommunityAdapter;
import com.bojue.homy.view.activity.CommentActivity;
import com.bojue.homy.view.activity.PublishFeelingActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 * 社区Fragment
 */

public class CommunityFragment extends BaseFragment implements ICommunityView,LoadDataScrollController.OnRecyclerRefreshListener{
    private final String TAG=this.getClass().getName();

    private View view;
    private RecyclerView rv_community;
    private SwipeRefreshLayout srl_community;
    private LoadDataScrollController mLoadDataScrollController;
    private ImageButton ib_publish_feeling;
    private List<CommunityBean> communityList;
    private int page=1;
    private AbstractCommunityPresenter mPresenter;
private CommunityAdapter adapter;
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.community_fragment,container,false);
        initView();
        return view;
    }

    private void initView() {
        //从MainActivity传递过来
        ib_publish_feeling = getActivity().findViewById(R.id.ib_publish_feeling);
        ib_publish_feeling.setVisibility(View.VISIBLE);
        rv_community = view.findViewById(R.id.rv_community);
        srl_community=view.findViewById(R.id.refreshLayout);

        mLoadDataScrollController=new LoadDataScrollController(this);
        srl_community.setColorSchemeResources(R.color.colorBackgroundLine);
        srl_community.setProgressViewOffset(true,0,10);
        rv_community.addOnScrollListener(mLoadDataScrollController);
        srl_community.setOnRefreshListener(mLoadDataScrollController);

        //设置为线性布局排列
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_community.setLayoutManager(linearLayoutManager);
    }
    @Override
    public void initData() {
        communityList= new ArrayList<>();
        ib_publish_feeling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),PublishFeelingActivity.class);
                startActivity(intent);
            }
        });

        //设置适配器
        adapter = new CommunityAdapter(communityList,getActivity());
        adapter.setItemListener(new CommunityAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.i(TAG, "onClick: "+position);
                Intent intent=new Intent(getActivity(),CommentActivity.class);
                getActivity().startActivity(intent);
            }
        });
        rv_community.setAdapter(adapter);

//        mPresenter=new CommunityPresenter();
        mPresenter=new ComPre();
        //获取当前view的实例
        mPresenter.attachView(this);
        //toDO:load data
        mPresenter.loadCommunity(page);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSeccuss) {

    }

    @Override
    public void onStop() {
        super.onStop();
        ib_publish_feeling.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    //回调ICommunityView接口
    @Override
    public void initCommunity(List<CommunityBean> communityBeanList) {
        //toDO:init Community
        if (page==1){
            this.communityList.clear();
        }
        this.communityList.addAll(communityBeanList);
        adapter.notifyDataSetChanged();
    }
//下拉刷新
    @Override
    public void onRefresh() {
        page=1;
        mPresenter.loadCommunity(page);
        mLoadDataScrollController.setLoadDataStatus(false);
        Log.i(TAG, "onRefresh: "+page);
        srl_community.setRefreshing(false);
    }
//加载更多
    @Override
    public void onLoadMore() {
        ++page;
        mPresenter.loadCommunity(page);
        Log.i(TAG, "onLoadMore: "+page);
        mLoadDataScrollController.setLoadDataStatus(false);
    }
}
