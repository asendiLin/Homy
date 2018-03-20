package com.bojue.homy.view.activity.land_register;

import com.bojue.homy.entity.LoginBean;
import com.bojue.homy.view.IView;

/**
 * Created by Xie on 2018/3/9.
 * 登陆接口
 */

public interface LoginView extends IView{

    //提交登陆信息
    void submitLogin(LoginBean mBean);

}
