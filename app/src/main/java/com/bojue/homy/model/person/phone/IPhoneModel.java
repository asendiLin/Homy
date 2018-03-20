package com.bojue.homy.model.person.phone;

import android.content.Context;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.PhoneBean;

import java.util.List;
import io.reactivex.Observable;

/**
 * Created by Xie on 2018/3/11.
 */

public interface IPhoneModel {

    Observable<BaseEntity<List<PhoneBean>>> getRegisterCode(String phoneNumber,String Id);

    Observable<BaseEntity<List<PhoneBean>>> submitContent(String phoneNumber,String code,String Id);

    public abstract PhoneBean getBean();

    public abstract PhoneBean initBean(Context context);
}
