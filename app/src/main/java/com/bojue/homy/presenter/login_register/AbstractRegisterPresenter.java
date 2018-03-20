package com.bojue.homy.presenter.login_register;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.activity.land_register.RegisterView;

/**
 * Created by Xie on 2018/1/17.
 * 注册的Presenter
 */

public abstract class AbstractRegisterPresenter extends BasePresenter<RegisterView>{
    /**
     * 验证用户名
     * @param name
     */
    public abstract void submitCheckName(String name);

    /**
     * 获取验证码
     * @param phoneNumber
     */
    public abstract void getRegisterCode(String phoneNumber);
    /**
     * 注册信息提交
     * @param name
     * @param pwd
     * @param phoneNumber
     * @param code
     */
    public abstract void submitRegisterContent(String name,String pwd,String phoneNumber,
                                                     String code);

}
