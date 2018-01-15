package com.bojue.homy.model.community;



import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.CommentBean;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.service.CommunityService;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by lizheng on 2018/1/8.
 * 社区的Model
 */

public class CommunityModel extends BaseModel implements ICommunityModel{

    CommunityService mService=this.createService(CommunityService.class);

    //读取社区心情页面方法

    @Override
    public Observable<BaseEntity<List<CommunityBean>>> loadCommunity(int page) {
        return mService.loadCommunity(page);
    }
    //展示社区评论页面方法
    @Override
    public Observable<BaseEntity<List<CommentBean>>> loadComment(int page, int cId) {
        return mService.loadComment(page, cId);
    }


    //提交评论
    @Override
    public Observable<BaseEntity<CommentBean>> submitComment(int uId, int cId, String commentContent,boolean isReply,String repliedName) {
        return mService.submitComment(uId,cId,commentContent,isReply,repliedName);
    }


    //提交心情
    @Override
    public Observable<BaseEntity<List<CommunityBean>>> submitCommunityFeeling(int uId, String imagUrl, String feelingContent,String mDate) {
        return mService.submitCommunityFeeling(uId, imagUrl, feelingContent,mDate);
    }


    //提交用户点赞的方法
    @Override
    public Observable<BaseEntity<List<CommunityBean>>> loadThumbUp(int cId,int uId) {
        return mService.loadThumbUp(cId,uId);
    }
}
