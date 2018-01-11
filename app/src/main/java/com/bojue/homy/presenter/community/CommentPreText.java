package com.bojue.homy.presenter.community;

import com.bojue.homy.entity.CommentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizheng on 2018/1/10.
 */

public class CommentPreText extends AbstractCommentPresenter {
    private List<CommentBean> commentBeanList;

    @Override
    public void loadComment(int page, int cId) {
        commentBeanList = new ArrayList<>();
        CommentBean people1 = new CommentBean("Lizheng1","1月1");
        commentBeanList.add(people1);
        CommentBean people2 = new CommentBean("Lizheng2","1月2");
        commentBeanList.add(people2);
        CommentBean people3 = new CommentBean("Lizheng3","1月3");
        commentBeanList.add(people3);
        CommentBean people4 = new CommentBean("Lizheng4","1月4");
        commentBeanList.add(people4);

        getView().showComment(commentBeanList);
    }

    @Override
    public void submitComment(int uId, int cId, String commentContent) {
        CommentBean comment1 = new CommentBean("Lizheng5","2月1日");
        commentBeanList.add(comment1);
        getView().showComment(commentBeanList);
        getView().showSendSuccess();
    }
}
