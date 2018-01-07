package com.bojue.homy.view.fragment.find;

import com.bojue.homy.entity.NeedItem;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/7.
 * 发现需求的View
 */

public interface IFindNeedView extends IView {
    /**
     * 展示需求列表数据
     * @param needItems
     */
    void showNeedItems(List<NeedItem> needItems);
}
