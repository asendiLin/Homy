package com.bojue.homy.model.person.phone;

import android.content.Context;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.PhoneBean;
import com.bojue.homy.service.PhoneService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Xie on 2018/3/11.
 */

public class PhoneModel extends BaseModel implements IPhoneModel{

    protected PhoneBean mBean = null;

    PhoneService mService = this.createService(PhoneService.class);

    @Override
    public Observable<BaseEntity<List<PhoneBean>>> getRegisterCode(String phoneNumber,String Id) {
        return mService.getRegisterCode(phoneNumber,Id)
                .compose(this.<BaseEntity<List<PhoneBean>>>setThread());
    }

    @Override
    public Observable<BaseEntity<List<PhoneBean>>> submitContent(String phoneNumber, String code,String Id) {
        return mService.submitContent(phoneNumber, code,Id)
                .compose(this.<BaseEntity<List<PhoneBean>>>setThread());
    }

    @Override
    public PhoneBean getBean() {
        return mBean;
    }

    @Override
    public PhoneBean initBean(Context context) {
        return mBean;
    }
}
