package com.bojue.homy.presenter.login_register;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.IView;

/**
 * Created by Xie on 2018/1/17.
 * 登录注册的Presenter
 */

public abstract class AbstractLoginAndRegisterPresenter extends BasePresenter<IView>{
    /**
     * 登录
     * @param name
     * @param pwd
     */
    public abstract void login(String name,String pwd);

}
