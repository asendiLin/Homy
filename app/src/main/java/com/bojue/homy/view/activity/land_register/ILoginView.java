package com.bojue.homy.view.activity.land_register;

import com.bojue.homy.view.IView;

/**
 * Created by lizheng on 2018/1/18.
 * 登陆的View接口
 */

public interface ILoginView extends IView {

   void loginOnSuccess(String isSuccess);

   void loginOnFail();
}
