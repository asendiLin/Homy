package com.bojue.homy.view.fragment.home;

import com.bojue.homy.entity.MarkerBean;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 * 首页的View
 */

public interface IHomeView extends IView {
    /**
     * 展示覆盖物
     * @param markerBeanList
     */
    void addOverlays(List<MarkerBean> markerBeanList );

}
