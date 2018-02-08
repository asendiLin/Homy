package com.bojue.homy.view.fragment.community;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.entity.CommentBean;
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
    private TextView zan_sum_community;
    private RecyclerView rv_community;
    private SwipeRefreshLayout srl_community;
    private LoadDataScrollController mLoadDataScrollController;
    private ImageButton ib_publish_feeling;
    private ViewStub mViewStub;
    private View errView;

    private List<CommunityBean> communityList;
    private int page=1;
    private AbstractCommunityPresenter mPresenter;
    private CommunityAdapter adapter;
    private int cId;
    private int uId = 1;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        view = inflater.inflate(R.layout.fragment_community,container,false);
        initView();
        return view;
    }



    private void initView() {
        //从MainActivity传递过来
        ib_publish_feeling = getActivity().findViewById(R.id.ib_publish_feeling);
        ib_publish_feeling.setVisibility(View.VISIBLE);
        rv_community = view.findViewById(R.id.rv_community);
        srl_community=view.findViewById(R.id.refreshLayout);
        mViewStub = view.findViewById(R.id.view_stub_err);
//        zan_sum_community = view.findViewById(R.id.zan_sum_community);

        //设置下拉刷新控件
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
                intent.putExtra("cId",position);
            }

            @Override
            public void onCheck(View view, int position) {
                cId = position;
                mPresenter.loadThumbUp(cId,uId);
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
        if (!isSeccuss) {
            srl_community.setVisibility(View.GONE);

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
        }else {//显示加载完成后的界面
            srl_community.setVisibility(View.VISIBLE);
            if (errView!=null)
                errView.setVisibility(View.GONE);
        }

        mLoadDataScrollController.setLoadDataStatus(false);
        srl_community.setRefreshing(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ib_publish_feeling.setVisibility(View.VISIBLE);
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
    //提交心情成功的回调
    @Override
    public void sendSuccess() {

    }
    //提交心情失败的回调
    @Override
    public void sendFail() {

    }
    //获取点赞数据
    //点赞成功
    @Override
    public void thumbUpSuccess(int position) {
        CommunityBean communityBean=communityList.get(position);

        if (communityBean.isStatus()){
            //说明取消
            communityList.get(position).setStatus(false);
            communityBean.setZan_sum_community(communityBean.getZan_sum_community()-1);
        }else {
            //说明点赞
            communityBean.setStatus(true);
            communityBean.setZan_sum_community(communityBean.getZan_sum_community()+1);
        }

        //修改communityList数据后刷新适配器显示点赞内容
        adapter.notifyDataSetChanged();

    }
    //点赞失败
    @Override
    public void thumbUpFail() {

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
