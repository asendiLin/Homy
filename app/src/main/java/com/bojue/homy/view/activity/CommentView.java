package com.bojue.homy.view.activity;

import com.bojue.homy.entity.CommentBean;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 * 显示评论列表的接口
 */

public interface CommentView extends IView {
    //显示评论列表
    void showComment(List<CommentBean> commentBeanList);
    //显示评论或回复
    void showoneContent(CommentBean data);
    //发送评论成功时回调
    void showSendSuccess();
    //发送评论失败时时回调
    void showSendFail();
}
