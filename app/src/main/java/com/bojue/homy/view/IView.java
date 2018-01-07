package com.bojue.homy.view;

/**
 * Created by Administrator on 2018/1/6.
 * View层的最高接口
 */

public interface IView {
    /**
     * 显示加载中
     */
    void showLoading();

    /**
     * 隐藏加载
     */
    void hideLoading(boolean isSuccess);
}
