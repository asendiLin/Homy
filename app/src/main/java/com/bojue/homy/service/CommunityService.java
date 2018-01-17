package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.CommentBean;
import com.bojue.homy.entity.CommunityBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lizheng on 2018/1/8.
 * 设置列表数据网络请求的接口
 */

public interface CommunityService {

    //请求社区心情数据方法
    @GET("")
    Observable<BaseEntity<List<CommunityBean>>> loadCommunity(@Query("page") int page);

    /*请求社区评论列表数据方法
     *page  页码
     *cId  评论ID（告知哪条心情）
     */
    @GET("")
    Observable<BaseEntity<List<CommentBean>>> loadComment(@Query("page") int page, @Query("") int cId);

    /*提交用户评论数据方法
     *uId  用户ID
     * cId  评论ID（告知哪条心情）
     * commentContent 评论内容
     */
    @POST("")
    Observable<BaseEntity<CommentBean>> submitComment(@Field("") int uId, @Field("") int cId, @Field("") String commentContent,@Field("") boolean isReply, @Field("")  String repliedName);
        /*提交用户心情内容的方法
     *uId  用户ID
     * imagUrl 照片地址
     * feelingContent 心情内容
     * mDate  当前时间
     */
    @POST("")
    Observable<BaseEntity<CommunityBean>> submitCommunityFeeling(@Field("") int uId,@Field("") String imagUrl, @Field("") String feelingContent,@Field("")String mDate);

    /*提交用户点赞的方法
   * cId  评论ID（告知哪条心情）
   * uId 用户ID
*/
    @POST("")
    Observable<BaseEntity<List<CommunityBean>>> loadThumbUp(@Field("") int cId,int uId);
}
