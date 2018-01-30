package com.bojue.homy.model.login_register;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.model.login_register.ILoginAndRegisterModel;
import com.bojue.homy.service.LoginAndRegisterService;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/25.
 * 登录注册的Model
 */

public class LoginAndRegisterModel extends BaseModel implements ILoginAndRegisterModel {

    private LoginAndRegisterService mService = this.createService(LoginAndRegisterService.class);

    @Override
    public Observable<BaseEntity<String>> login(String name, String pwd) {
        return mService.login(name, pwd)
                .compose(this.<BaseEntity<String>>setThread());
    }

    @Override
    public Observable<BaseEntity<String>> submitCheckName(String name) {
        return null;
    }

    @Override
    public Observable<BaseEntity<String>> getRegisterCode(String phoneNumber) {
        return null;
    }

    @Override
    public Observable<BaseEntity<String>> submitRegisterContent(String name, String pwd, String phoneNumber, String code) {
        return null;
    }
}
