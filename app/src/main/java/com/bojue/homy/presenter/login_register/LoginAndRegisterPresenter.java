package com.bojue.homy.presenter.login_register;

import android.util.Log;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.LoginBean;
import com.bojue.homy.model.login_register.ILoginAndRegisterModel;
import com.bojue.homy.model.login_register.LoginAndRegisterModel;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25.
 */

public class LoginAndRegisterPresenter extends AbstractLoginAndRegisterPresenter {
    private ILoginAndRegisterModel mModel;

    public LoginAndRegisterPresenter(){
        mModel=new LoginAndRegisterModel();
    }
    //登陆
    @Override
    public void login(String name, String pwd) {
        mModel.login(name, pwd)
                .subscribe(new BaseObserver<LoginBean>() {

                    @Override
                    public void onSuccess(LoginBean data) {
                        Log.i("TAG","on Sucess:");
                        mModel.getmBean().setNickname(data.getNickname());
                        getView().submitLogin(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        Log.i("TAG", "onFail: "+throwable.getMessage());
                    }

                    @Override
                    public void onResultMsg(String msg) {
                        super.onResultMsg(msg);
                        Log.i("TAG", "onResultMsg: "+msg);
                    }
                });
    }

}
