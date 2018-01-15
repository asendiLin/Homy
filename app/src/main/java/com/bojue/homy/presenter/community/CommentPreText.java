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
        CommentBean people1 = new CommentBean("Lizheng1","1月1",false,"");
        commentBeanList.add(people1);
        CommentBean people2 = new CommentBean("Lizheng2","1月2",false,"");
        commentBeanList.add(people2);
        CommentBean people3 = new CommentBean("Lizheng3","1月3",false,"");
        commentBeanList.add(people3);
//        CommentBean people4 = new CommentBean("Lizheng4","1月4",false,"");
//        commentBeanList.add(people4);
//        CommentBean people5 = new CommentBean("Lizheng5","1月1",false,"");
//        commentBeanList.add(people5);
//        CommentBean people6 = new CommentBean("Lizheng6","1月2",false,"");
//        commentBeanList.add(people6);

        getView().showComment(commentBeanList);
    }

    @Override
    public void submitComment(int uId, int cId, String commentContent,boolean isReply, String repliedName) {
        CommentBean comment1;
        if(isReply){
            comment1 = new CommentBean("Lizheng5","2月1日",isReply,repliedName);
        }else {
            comment1 = new CommentBean("Lizheng5", "2月1日", false,"");
        }
        getView().showoneContent(comment1);
        getView().showSendSuccess();
    }
}
