package com.bojue.homy.model.register;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.RegisterBean;

import java.util.List;
import io.reactivex.Observable;

/**
 * Created by Xie on 2018/1/17.
 * 注册界面的Model
 */

public interface IRegisterModel  {
    /**
     * 第一次提交，提交名字
     * @param name
     * @return
     */
    Observable<BaseEntity<List<RegisterBean>>> submitRegisterContentFirst(String name);

    /**
     *
     * @param name
     * @param password
     * @param phone
     * @return
     */
    Observable<BaseEntity<List<RegisterBean>>> submitRegisterContentSecond(String name,String password,int phone);

    /**
     * 第三次提交，提交用户全部信息
     * @param name
     * @param password
     * @param phone
     * @param code
     * @return
     */
    Observable<BaseEntity<List<RegisterBean>>> submitRegisterContentThird(String name,String password,int phone,int code);

}
