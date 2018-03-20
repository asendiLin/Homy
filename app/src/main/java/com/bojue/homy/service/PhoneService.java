package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.PhoneBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Xie on 2018/3/11.
 */

public interface PhoneService {
    @FormUrlEncoded
    @POST("hemy/user/getCode")
    Observable<BaseEntity<List<PhoneBean>>> getRegisterCode(@Field("phoneNumber") String phoneNumber,@Field("userId") String Id );

    @FormUrlEncoded
    @POST("hemy/user/updatePhoneNumber")
    Observable<BaseEntity<List<PhoneBean>>> submitContent(@Field("newPhoneNumber") String phoneNumber,@Field("code") String code,@Field("userId") String Id );
}
