package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.LoginBean;
import com.bojue.homy.entity.RegisterBean;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Xie on 2018/1/17.
 * 注册界面的请求网络Service
 */

public interface LoginAndRegisterService {
    /**
     * 登录
     * @param name
     * @return
     */
    @FormUrlEncoded
    @POST("hemy/user/login")
    Observable<BaseEntity<LoginBean>>login(@Field("username") String name, @Field("password") String pwd);

    /**
     * 验证用户名
     * @param name
     * @return
     */
    @FormUrlEncoded
    @POST("/")
    Observable<BaseEntity<RegisterBean>>submitCheckName(@Field("username")String name);

    /**
     * 获取验证码
     * @param phoneNumber
     * @return
     */
    @FormUrlEncoded
    @POST("hemy/user/getCode")
    Observable<BaseEntity<RegisterBean>> getRegisterCode(@Field("phoneNumber") String phoneNumber);
    /**
     * 提交注册信息
     * @param name
     * @param password
     * @param phone
     * @param checkcode
     * @return
     */
    @FormUrlEncoded
    @POST("hemy/user/register")
    Observable<BaseEntity<RegisterBean>> submitRegisterContent(@Field("nickname") String name,
                                                                     @Field("password") String password,
                                                                     @Field("username") String phone,
                                                                     @Field("code") String checkcode);
}
