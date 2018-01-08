package com.bojue.homy.view.fragment.person;

import com.bojue.homy.entity.NeedItem;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by Xie on 2018/1/8.
 * 个人中心的view接口
 */

public interface IPersonView extends IView {
    /**
     * 展示需求列表数据
     * @param needItems
     */
    void showNeedItems(List<NeedItem> needItems);
}
