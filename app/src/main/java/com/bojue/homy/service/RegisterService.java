package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.RegisterBean;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by Xie on 2018/1/17.
 * 注册界面的请求网络Service
 */

public interface RegisterService {
    /**
     * 第一次提交，提交用户名字
     * @param name
     * @return
     */
    @POST("")
    Observable<BaseEntity<List<RegisterBean>>> submitRegisterContentFirst(@Field("name") String name);

    /**
     * 第二次提交 提交验证码
     * @param checkcode
     * @return
     */
    @POST("")
    Observable<BaseEntity<List<RegisterBean>>> submitRegisterContentSecond(@Field("checkcode") int checkcode);
    /**
     * 第三次提交，提交全部信息
     * @param name
     * @param password 密码
     * @param password_again 再次的密码
     * @param phone
     * @param checkcode 验证码
     * @return
     */
    @POST("")
    Observable<BaseEntity<List<RegisterBean>>> submitRegisterContentThird(@Field("name") String name,
                                                                     @Field("password") String password,
                                                                     @Field("password_again") String password_again,
                                                                     @Field("phone") int phone,
                                                                     @Field("checkcode") int checkcode);

}
