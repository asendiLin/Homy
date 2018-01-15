package com.bojue.homy.presenter.publish;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.fragment.publish.IPublishView;

/**
 * Created by lizheng on 2018/1/8.
 */

public abstract class AbstractPublishPresenter extends BasePresenter<IPublishView> {
    //提交发布需求数据
    public abstract void submitPublishContent(int uId, String price, String phoneNum, String needType, String startTime, String endTime, String needContent, String latitude, String longitude);

}
