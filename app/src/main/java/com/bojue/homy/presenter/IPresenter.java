package com.bojue.homy.presenter;

import com.bojue.homy.view.IView;

/**
 * Created by Administrator on 2018/1/6.
 * Presenter层最高接口
 */

public interface IPresenter<T extends IView> {
    /**
     * 绑定View
     */
    void attachView(T view);
    /**
     * 解绑View
     */
    void detachView();
    /**
     * 获取View
     */
    T getView();
}
