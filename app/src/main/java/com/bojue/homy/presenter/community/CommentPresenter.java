package com.bojue.homy.presenter.community;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.CommentBean;
import com.bojue.homy.model.community.CommunityModel;
import com.bojue.homy.model.community.ICommunityModel;

import java.util.List;

/**
 * Created by lizheng on 2018/1/9.
 * 评论页面的present
 */

public class CommentPresenter extends AbstractCommentPresenter {
    private ICommunityModel mModel;
    public CommentPresenter() {
        mModel = new CommunityModel();
    }


    //显示评论
    @Override
    public void loadComment(int page, int cId) {
        mModel.loadComment(page,cId)
                .subscribe(new BaseObserver<List<CommentBean>>() {
                    @Override
                    public void onSuccess(List<CommentBean> data) {
                        getView().showComment(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });
    }

    //提交评论
    @Override
    public void submitComment(int uId, int cId, String commentContent,boolean isReply,String repliedName) {
        mModel.submitComment(uId, cId, commentContent,isReply,repliedName)
                .subscribe(new BaseObserver<CommentBean>() {
                    @Override
                    public void onSuccess(CommentBean data) {
                        getView().showoneContent(data);
                        getView().showSendSuccess();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        getView().showSendFail();
                    }
                });

    }

}
