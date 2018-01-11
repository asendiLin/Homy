package com.bojue.homy.model.community;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.CommentBean;
import com.bojue.homy.entity.CommunityBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lizheng on 2018/1/8.
 * 社区Model的接口
 */

public interface ICommunityModel {
    //读取社区心情页面方法
    Observable<BaseEntity<List<CommunityBean>>> loadCommunity(int page);
    /*展示社区评论页面方法
    *page 页码
    * pageID 哪一个心情页面
     */
    Observable<BaseEntity<List<CommentBean>>>   loadComment(int page,int cId);
    /*
    *提交评论
     *uId  用户ID
     * pageId  评论ID（告知哪条心情）
     * commentContent 评论内容
     */
    Observable<BaseEntity<List<CommentBean>>>   submitComment(int uId,int cId,String commentContent);

        /*
    *提交心情
     *uId  用户ID
     * imagUrl  发布的图片信息
     * commentContent 发布的心情内容
     */
    Observable<BaseEntity<List<CommunityBean>>> submitCommunityFeeling(int uId,String imagUrl,String feelingContent);
        /*提交用户点赞的方法
* pageId  评论ID（告知哪条心情）
*/
        Observable<BaseEntity<List<CommunityBean>>> loadThumbUp(int cId);

}
