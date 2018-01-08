package com.bojue.homy.presenter.community;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.fragment.community.ICommunityView;

/**
 * Created by lizheng on 2018/1/8.
 * 社区的Presenter的抽象类
 */

public abstract class AbstractCommunityPresenter extends BasePresenter<ICommunityView>{

    public abstract void loadCommunity(int page);

}
