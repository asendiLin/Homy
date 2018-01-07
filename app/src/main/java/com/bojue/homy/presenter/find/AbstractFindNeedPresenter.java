package com.bojue.homy.presenter.find;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.fragment.find.IFindNeedView;

/**
 * Created by Administrator on 2018/1/7.
 * 发现需求的Presenter的抽象类
 */

public abstract class AbstractFindNeedPresenter extends BasePresenter<IFindNeedView> {
    /**
     * 获取需求列表
     * @param type ：需求类别
     * @param uId : 用户id
     * @param page ：页码
     */
    public abstract void loadNeed(String type,String uId,int page);

}
