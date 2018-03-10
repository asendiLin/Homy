package com.bojue.homy.model.login;


import com.bojue.homy.base.BaseEntity;

import io.reactivex.Observable;

/**
 * Created by lizheng on 2018/1/18.
 * 登陆界面model的接口
 */

public interface ILoginModel{
    Observable<BaseEntity<String>> submitLoginInformation(String loginPhone, String loginpassword);
}
