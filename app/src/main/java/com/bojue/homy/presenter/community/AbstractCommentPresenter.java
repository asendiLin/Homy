package com.bojue.homy.presenter.community;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.activity.CommentView;

/**
 * Created by lizheng on 2018/1/9.
 * 评论页面的抽象presenter
 */

public abstract  class AbstractCommentPresenter extends BasePresenter<CommentView>{
    //显示评论
    public abstract void loadComment(int page,int cId);

    //提交评论或回复
    public abstract void submitComment(int uId, int cId, String commentContent,boolean isReply,String repliedName);

}
