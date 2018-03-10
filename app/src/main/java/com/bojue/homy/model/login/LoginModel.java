package com.bojue.homy.model.login;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.service.LoginService;

import io.reactivex.Observable;

/**
 * Created by lizheng on 2018/1/18.
 * 登陆的Model
 */

public class LoginModel extends BaseModel implements ILoginModel {
    LoginService mService = this.createService(LoginService.class);
    /**
     * 提交用户登陆信息方法
     * @param loginPhone 手机
     * @param loginpassword 密码
     * @return
     */
    @Override
    public Observable<BaseEntity<String>> submitLoginInformation(String loginPhone, String loginpassword) {

        return mService.submitLoginInformation(loginPhone, loginpassword)
                .compose(this.<BaseEntity<String>>setThread());
    }
}
