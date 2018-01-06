package com.bojue.homy.base;

import com.bojue.homy.global.GlobalContent;

/**
 * Created by Administrator on 2018/1/6.
 * 数据实体的基类
 */

public class BaseEntity<T> {

    private int code;//返回码
    private String msg;//返回的信息
    private T data;//返回的数据

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    /**
     * 判断是否请求码成功
     */
    public boolean isSuccess(){
        return this.code== GlobalContent.SUCCESS_CODE;
    }
}
