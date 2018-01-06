package com.bojue.homy.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2018/1/6.
 * 用于网络请求基类
 */

public abstract class BaseObserver<T> implements Observer<BaseEntity<T>> {


    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    @Override
    public void onNext(BaseEntity<T> tBaseEntity) {
        onRequestEnd(true);
        onResultMsg(tBaseEntity.getMsg());
        if (tBaseEntity.isSuccess()) {
            onSuccess(tBaseEntity.getData());
        } else {
            onCodeError();
        }
    }

    @Override
    public void onComplete() {
        onRequestEnd(true);
    }

    @Override
    public void onError(Throwable e) {
        onRequestEnd(false);
    }

    /**
     * 请求成功
     *
     * @param data
     */
    abstract void onSuccess(T data);


    /**
     * 失败返回码
     */
    public void onCodeError() {
    }

    /**
     * 请求开始
     */
    public void onRequestStart() {
    }

    /**
     * 请求结束
     */
    public void onRequestEnd(boolean isSuccess) {
    }

    /**
     * 请求返回信息
     */
    public void onResultMsg(String msg) {
    }
}
