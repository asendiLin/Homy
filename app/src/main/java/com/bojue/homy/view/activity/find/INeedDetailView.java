package com.bojue.homy.view.activity.find;

import com.bojue.homy.entity.NeedDetailBean;
import com.bojue.homy.view.IView;

/**
 * Created by Administrator on 2018/1/9.
 * 需求详情View
 */

public interface INeedDetailView extends IView {
    /**
     * 显示需求详情
     * @param needDetailBean
     */
    void showNeedDetail(NeedDetailBean needDetailBean);

    /**
     * 接单结果
     * @param isSuccess
     */
    void showAcceptResult(boolean isSuccess);
}
