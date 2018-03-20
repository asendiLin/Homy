package com.bojue.homy.presenter.login_register;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.entity.LoginBean;
import com.bojue.homy.view.IView;
import com.bojue.homy.view.activity.land_register.LoginView;

/**
 * Created by Xie on 2018/1/17.
 * 登录注册的Presenter
 */

public abstract class AbstractLoginAndRegisterPresenter extends BasePresenter<LoginView>{
    protected LoginBean mBean = null;

    public LoginBean getmBean() {
        return mBean;
    }

    /**
     * 登录
     * @param name
     * @param pwd
     */
    public abstract void login(String name,String pwd);


}
