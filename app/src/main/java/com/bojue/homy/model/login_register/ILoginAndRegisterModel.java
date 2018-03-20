package com.bojue.homy.model.login_register;

import android.content.Context;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.LoginBean;
import com.bojue.homy.entity.RegisterBean;
import com.bojue.homy.model.IModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/25.
 * 登录和注册的接口
 */

public interface ILoginAndRegisterModel extends IModel {

    public abstract LoginBean getmBean();
    public abstract LoginBean initBean(Context context);

    /**
     *登录
     * @param name
     * @param pwd
     * @return
     */
    Observable<BaseEntity<LoginBean>>login(String name,String pwd);

    /**
     * 验证用户名
     * @param name
     * @return
     */
    Observable<BaseEntity<RegisterBean>>submitCheckName(String name);

    /**
     * 获取验证码
     * @param phoneNumber
     * @return
     */
    Observable<BaseEntity<RegisterBean>> getRegisterCode(String phoneNumber);

    /**
     * 提交注册信息
     * @param name
     * @param pwd
     * @param phoneNumber
     * @param code
     * @return
     */
    Observable<BaseEntity<RegisterBean>> submitRegisterContent(String name,String pwd,String phoneNumber,
                                                         String code);
}
