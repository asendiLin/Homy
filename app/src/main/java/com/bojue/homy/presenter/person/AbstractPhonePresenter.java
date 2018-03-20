package com.bojue.homy.presenter.person;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.model.person.phone.PhoneModel;
import com.bojue.homy.view.activity.person.phone.MyPhoneView;

/**
 * Created by Xie on 2018/3/11.
 */

public abstract class AbstractPhonePresenter extends BasePresenter<MyPhoneView>{

    public abstract void getRegisterCode(String phoneNumber,String Id);

    public abstract void submitContent(String phoneNumber,String code,String Id);
}
