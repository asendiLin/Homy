package com.bojue.homy.model.login_register;

import android.content.Context;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.LoginBean;
import com.bojue.homy.entity.RegisterBean;
import com.bojue.homy.model.login_register.ILoginAndRegisterModel;
import com.bojue.homy.service.LoginAndRegisterService;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/25.
 * 登录和注册的Model
 */

public class LoginAndRegisterModel extends BaseModel implements ILoginAndRegisterModel {

    protected LoginBean mBean = null;

    @Override
    public LoginBean getmBean() {
        return mBean;
    }

    @Override
    public LoginBean initBean(Context context) {
        return mBean;
    }

    private LoginAndRegisterService mService = this.createService(LoginAndRegisterService.class);
    /**
     * 登陆
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public Observable<BaseEntity<LoginBean>> login(String name, String pwd) {
        return mService.login(name, pwd)
                .compose(this.<BaseEntity<LoginBean>>setThread());
    }

    @Override
    public Observable<BaseEntity<RegisterBean>> submitCheckName(String name) {
        return mService.submitCheckName(name)
                .compose(this.<BaseEntity<RegisterBean>>setThread());
    }

    /**
     * 获取验证码
     * @param phoneNumber
     * @return
     */
    @Override
    public Observable<BaseEntity<RegisterBean>> getRegisterCode(String phoneNumber) {
        return mService.getRegisterCode(phoneNumber)
                .compose(this.<BaseEntity<RegisterBean>>setThread());
    }

    /**
     * 提交注册信息
     * @param name
     * @param pwd
     * @param phoneNumber
     * @param code
     * @return
     */
    @Override
    public Observable<BaseEntity<RegisterBean>> submitRegisterContent(String name, String pwd, String phoneNumber, String code) {
        return mService.submitRegisterContent(name,pwd,phoneNumber,code)
                .compose(this.<BaseEntity<RegisterBean>>setThread());
    }
}
