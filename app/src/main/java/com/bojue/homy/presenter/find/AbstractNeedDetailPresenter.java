package com.bojue.homy.presenter.find;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.activity.find.INeedDetailView;

/**
 * Created by Administrator on 2018/1/15.
 * 需求详情Presenter层抽象
 */

public abstract class AbstractNeedDetailPresenter extends BasePresenter<INeedDetailView> {
    /**
     * 获取需求详情
     * @param id
     */
    public abstract void getNeedDetail(String id);

    /**
     * 接单
     * @param nId
     * @param uId
     */
    public abstract void accept(String nId,String uId);
}
