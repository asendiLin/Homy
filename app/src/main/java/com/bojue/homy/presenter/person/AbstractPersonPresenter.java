package com.bojue.homy.presenter.person;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.fragment.person.IPersonView;

/**
 * Created by Administrator on 2018/1/7.
 * 个人中心的Presenter的抽象类
 */

public abstract class AbstractPersonPresenter extends BasePresenter<IPersonView> {

    public abstract void loadDemand(int page);

    public abstract void loadOrder(int page);
}
