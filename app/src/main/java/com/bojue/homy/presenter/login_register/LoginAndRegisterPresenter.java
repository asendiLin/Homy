package com.bojue.homy.presenter.login_register;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.model.login_register.ILoginAndRegisterModel;
import com.bojue.homy.model.login_register.LoginAndRegisterModel;

/**
 * Created by Administrator on 2018/1/25.
 */

public class LoginAndRegisterPresenter extends AbstractLoginAndRegisterPresenter {
    private ILoginAndRegisterModel mModel;

    public LoginAndRegisterPresenter(){
        mModel=new LoginAndRegisterModel();
    }

    @Override
    public void login(String name, String pwd) {
        mModel.login(name, pwd)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void onSuccess(String data) {
                        getView().hideLoading(true);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }

                });
    }
}
