package com.bojue.homy.view.fragment.community;

import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 * 读取列表数据的接口
 */

public interface ICommunityView extends IView {

    void initCommunity(List<CommunityBean> communityBeanList);

}
