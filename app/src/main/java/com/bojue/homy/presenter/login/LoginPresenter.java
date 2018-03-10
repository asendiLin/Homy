package com.bojue.homy.presenter.login;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.model.login.ILoginModel;
import com.bojue.homy.model.login.LoginModel;

/**
 * Created by lizheng on 2018/1/18.
 */

public class LoginPresenter extends AbstractLoginPresenter {

    private ILoginModel mModel;
    public LoginPresenter() {
        mModel = new LoginModel();
    }

    /**
     * 提交用户登陆信息
     * @param loginPhone
     * @param loginpassword
     */
    @Override
    public void submitLoginInformation(String loginPhone, String loginpassword) {

        mModel.submitLoginInformation(loginPhone, loginpassword)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void onSuccess(String data) {

                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });
    }
}
