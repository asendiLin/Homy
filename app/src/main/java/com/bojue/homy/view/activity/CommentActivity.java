package com.bojue.homy.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bojue.homy.R;
import com.bojue.homy.base.BaseActivity;
import com.bojue.homy.entity.CommentBean;
import com.bojue.homy.presenter.community.AbstractCommentPresenter;
import com.bojue.homy.presenter.community.CommentPreText;
import com.bojue.homy.utils.https.load.LoadDataScrollController;
import com.bojue.homy.view.adapter.CommentAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends BaseActivity implements CommentView,View.OnClickListener,LoadDataScrollController.OnRecyclerRefreshListener{
    private ImageButton ib_back_community;
    private Button bt_send_comment;
    private Button bt_send_reply;
    private Button bt_cancel_reply;
    private RecyclerView rv_comment;
//    private TextView dialog_title;
    private CommentAdapter mAdapter;
    private LoadDataScrollController mLoadDataScrollController;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<CommentBean> mCommentBeanList;
    private EditText et_comment;
    private AbstractCommentPresenter mPresenter;
    private int page =1;
    private int cId;
    private int uId =1;
    private LinearLayoutManager linearLayoutManager;
    private AlertDialog.Builder dialog;
    private EditText et_reply_content;
    private AlertDialog dialogReply;
    private String repliedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initView();
        initData();
    }


    private void initView() {
        ib_back_community = findViewById(R.id.ib_back_community);
        bt_send_comment =findViewById(R.id.bt_send_comment);
        et_comment = findViewById(R.id.et_comment);
        et_comment.setFocusable(true);
        ib_back_community.setVisibility(View.VISIBLE);
        ib_back_community.setOnClickListener(this);
        bt_send_comment.setOnClickListener(this);
        mSwipeRefreshLayout = findViewById(R.id.refreshLayout);
        rv_comment = findViewById(R.id.rv_comment);
        //设置为线性布局排列
        linearLayoutManager = new LinearLayoutManager(this);
        rv_comment.setLayoutManager(linearLayoutManager);

        //设置下拉刷新的监听和布局
        mLoadDataScrollController=new LoadDataScrollController(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBackgroundLine);
        mSwipeRefreshLayout.setProgressViewOffset(true,0,10);
        rv_comment.addOnScrollListener(mLoadDataScrollController);
        mSwipeRefreshLayout.setOnRefreshListener(mLoadDataScrollController);
    }

    private void initData() {
        mCommentBeanList = new ArrayList<>();
        //传入cId，点击某条心情的位置
        Intent intent = getIntent();
        cId = intent.getIntExtra("cId",0);
        //设置适配器
       mAdapter = new CommentAdapter(mCommentBeanList);
       rv_comment.setAdapter(mAdapter);


        //       mPresenter = new CommentPresenter();
        mPresenter = new CommentPreText();
        mPresenter.attachView(this);
        mPresenter.loadComment(page,cId);


        mAdapter.setItemListener(new CommentAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                CommentBean commentBean= mCommentBeanList.get(position);
                repliedName = commentBean.getName();
                //初始化自定义的dialog
                dialogReply = new AlertDialog.Builder(CommentActivity.this).create();
                dialogReply.setView(LayoutInflater.from(CommentActivity.this).inflate(R.layout.reply_dialog,null));

                //设置dialog的屏幕适配
                Window dialogWindow = dialogReply.getWindow();
                dialogReply.setCanceledOnTouchOutside(false);
                dialogWindow.setGravity(Gravity.BOTTOM);
                dialogReply.show();



                //设置dialog的view视图和监听事件
                bt_send_reply = dialogReply.findViewById(R.id.bt_send_reply);
                bt_cancel_reply = dialogReply.findViewById(R.id.bt_cancel_reply);
                et_reply_content = dialogReply.findViewById(R.id.et_reply_content);
                et_reply_content.setHint("回复"+commentBean.getName()+":");

                bt_send_reply.setOnClickListener(CommentActivity.this);
                bt_cancel_reply.setOnClickListener(CommentActivity.this);

                }
        });

    }

    /**
     * 点击评论按钮
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_back_community:
                finish();
                break;
            case R.id.bt_send_comment:
                String comment =  et_comment.getText().toString();
                if (TextUtils.isEmpty(comment)){
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    mPresenter.submitComment(uId, cId, comment,false,repliedName);

                }
                break;
            case R.id.bt_send_reply:
                String reply = et_reply_content.getText().toString();
                if (TextUtils.isEmpty(reply)){
                    et_reply_content.setError("内容不能为空");
                }else{
                    mPresenter.submitComment(uId, cId, reply,true,repliedName);
                    dialogReply.dismiss();
                }
                break;
            case R.id.bt_cancel_reply:
                dialogReply.dismiss();
                break;
                default:
        }
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
    //回调CommentView接口
    @Override
    public void showComment(List<CommentBean> commentBeanList) {
        if(page == 1){
            mCommentBeanList.clear();
        }
        mCommentBeanList.addAll(commentBeanList);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 显示评论或回复
     * @param data
     */
    @Override
    public void showoneContent(CommentBean data) {
        mCommentBeanList.add(data);
    }

    //发送评论成功时回调
    @SuppressLint("RestrictedApi")
    @Override
    public void showSendSuccess() {
        rv_comment.smoothScrollToPosition(mCommentBeanList.size());
         dialog = new AlertDialog.Builder(this)
                 .setMessage("发送成功")
                 .setCancelable(false)
                 .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         et_comment.setText("");
                     }
                 });
         dialog.show();
        mAdapter.notifyDataSetChanged();
    }
    //发送评论失败时时回调
    @Override
    public void showSendFail() {

    }

    //下拉刷新
    @Override
    public void onRefresh() {
        page=1;
        mPresenter.loadComment(page,cId);
        mLoadDataScrollController.setLoadDataStatus(false);
        mSwipeRefreshLayout.setRefreshing(false);
    }
    //加载更多
    @Override
    public void onLoadMore() {
//        ++page;
//        mPresenter.loadComment(page,cId);
//        mLoadDataScrollController.setLoadDataStatus(false);
    }
}
