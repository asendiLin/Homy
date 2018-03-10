package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;

import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lizheng on 2018/1/18.
 * 登陆的联网请求Service
 */
public interface LoginService {
    /**
     * 提交登陆信息
     * @param loginPhone  手机号（账号）
     * @param loginpassword 密码
     * @return
     */
    @FormUrlEncoded
    @POST("test")
    Observable<BaseEntity<String>> submitLoginInformation(@Field("username") String loginPhone,
                                                         @Field("passwd") String loginpassword);

}
