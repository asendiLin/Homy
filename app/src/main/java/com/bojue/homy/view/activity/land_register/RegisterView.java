package com.bojue.homy.view.activity.land_register;

import com.bojue.homy.entity.RegisterBean;
import com.bojue.homy.view.IView;

/**
 * Created by Xie on 2018/1/18.
 * 注册的接口
 */

public interface RegisterView extends IView {

    //注册提交成功
    void submitRegisterSuccess();


    //验证用户名
    void submitCheckName();

    //获取验证码
    void getRegisterCode();
}
