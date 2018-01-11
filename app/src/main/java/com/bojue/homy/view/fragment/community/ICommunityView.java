package com.bojue.homy.view.fragment.community;

import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 * 读取列表数据的接口
 */

public interface ICommunityView extends IView {
    //显示心情item的方法
    void initCommunity(List<CommunityBean> communityBeanList);

    //提交心情成功的回调
    void sendSuccess();

    //提交心情失败的回调
    void sendFail();

    //点赞成功
    void thumbUpSuccess(int position);

    //点赞失败
    void thumbUpFail();

}
