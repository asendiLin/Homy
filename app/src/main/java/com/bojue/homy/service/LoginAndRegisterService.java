package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.RegisterBean;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    @POST("")
    Observable<BaseEntity<String>>login(@Field("") String name,@Field("") String pwd);

    /**
     * 验证用户名
     * @param name
     * @return
     */
    @FormUrlEncoded
    @POST("")
    Observable<BaseEntity<String>>submitCheckName(@Field("")String name);

    /**
     * 获取验证码
     * @param code
     * @return
     */
    @POST("")
    Observable<BaseEntity<String>> getRegisterCode(@Field("") String code);
    /**
     * 提交注册信息
     * @param name
     * @param password 密码
     * @param password_again 再次的密码
     * @param phone
     * @param checkcode 验证码
     * @return
     */
    @POST("")
    Observable<BaseEntity<String>> submitRegisterContent(@Field("name") String name,
                                                                     @Field("password") String password,
                                                                     @Field("password_again") String password_again,
                                                                     @Field("phone") int phone,
                                                                     @Field("checkcode") int checkcode);

}
