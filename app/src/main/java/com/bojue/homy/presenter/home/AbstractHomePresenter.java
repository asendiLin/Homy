package com.bojue.homy.presenter.home;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.fragment.home.IHomeView;

/**
 * Created by Administrator on 2018/1/12.
 * 首页的Presenter
 */

public abstract class AbstractHomePresenter extends BasePresenter<IHomeView> {

    public abstract void getMarker(int uId);

}
