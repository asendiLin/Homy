package com.bojue.homy.presenter.login_register;

import android.util.Log;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.RegisterBean;
import com.bojue.homy.model.login_register.ILoginAndRegisterModel;
import com.bojue.homy.model.login_register.LoginAndRegisterModel;
import com.bojue.homy.model.register.IRegisterModel;

import java.util.List;

/**
 * Created by Xie on 2018/1/17.
 * 注册界面的Presenter
 */

public class RegisterPresenter extends AbstractRegisterPresenter {
    ILoginAndRegisterModel mILoginAndRegisterModel;

    public RegisterPresenter(){
        mILoginAndRegisterModel=new LoginAndRegisterModel();
    }
    //提交注册信息
    @Override
    public void submitRegisterContent(String name, String pwd, String phoneNumber, String code) {
        mILoginAndRegisterModel.submitRegisterContent(name, pwd, phoneNumber, code)
                .subscribe(new BaseObserver<RegisterBean>() {
                    @Override
                    public void onSuccess(RegisterBean data) {
                        Log.e("Tag","注册成功");
                        getView().submitRegisterSuccess();
                    }
                    @Override
                    public void onFail(Throwable throwable) {
                        Log.e("Tag","注册失败原因:"+throwable.getMessage());
                    }

                    @Override
                    public void onCodeError() {
                        super.onCodeError();
                        Log.i("TAG", "onCodeError: ");
                    }

                    @Override
                    public void onResultMsg(String msg) {
                        super.onResultMsg(msg);
                        Log.i("TAG", "onResultMsg: "+msg);
                    }
                });
    }
    //验证用户名
    @Override
    public void submitCheckName(String name) {
        mILoginAndRegisterModel.submitCheckName(name)
                .subscribe(new BaseObserver<RegisterBean>() {
                    @Override
                    public void onSuccess(RegisterBean data) {
                        Log.i("TAG","on Sucess");
                        getView().submitCheckName();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        Log.i("TAG","on Fail"+throwable.getMessage());
                    }
                });

    }
    //获取验证码
    @Override
    public void getRegisterCode(String phoneNumber) {
        mILoginAndRegisterModel.getRegisterCode(phoneNumber)
                .subscribe(new BaseObserver<RegisterBean>() {
                    @Override
                    public void onSuccess(RegisterBean data) {
                        Log.i("TAG","on Sucess");
                        getView().getRegisterCode();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        Log.i("TAG","on Fail"+throwable.getMessage());
                    }
                });

    }
}
