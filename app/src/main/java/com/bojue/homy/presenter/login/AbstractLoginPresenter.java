package com.bojue.homy.presenter.login;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.activity.land_register.ILoginView;

/**
 * Created by lizheng on 2018/1/18.
 */

public abstract  class AbstractLoginPresenter extends BasePresenter<ILoginView> {
    /**
     * 提交用户登陆信息
     * @param loginPhone
     * @param loginpassword
     */
    public abstract void submitLoginInformation(String loginPhone, String loginpassword);
}
