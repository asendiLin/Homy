package com.bojue.homy.presenter.person;

import android.util.Log;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.PhoneBean;
import com.bojue.homy.model.person.phone.IPhoneModel;
import com.bojue.homy.model.person.phone.PhoneModel;

import java.util.List;

/**
 * Created by Xie on 2018/3/11.
 */

public class PhonePresenter extends AbstractPhonePresenter {
    private IPhoneModel mModel;

    public PhonePresenter() {
        this.mModel = new PhoneModel();
    }

    @Override
    public void getRegisterCode(String phoneNumber,String Id) {
        mModel.getRegisterCode(phoneNumber,Id)
                .subscribe(new BaseObserver<List<PhoneBean>>() {
                    @Override
                    public void onSuccess(List<PhoneBean> data) {
                        Log.i("TAG","on Sucess");
                        getView().getRegisterCode();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        Log.i("TAG","on Fail"+throwable.getMessage());
                    }
                });
    }

    @Override
    public void submitContent(String phoneNumber, String code,String Id) {
        mModel.submitContent(phoneNumber, code,Id)
                .subscribe(new BaseObserver<List<PhoneBean>>() {
                    @Override
                    public void onSuccess(List<PhoneBean> data) {
                        Log.i("TAG","on Sucess");
                        getView().submitContent();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        Log.i("TAG","on Fail"+throwable.getMessage());
                    }
                });
    }
}
