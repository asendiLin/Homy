package com.bojue.homy.base;

import com.bojue.homy.presenter.IPresenter;
import com.bojue.homy.view.IView;

/**
 * Created by Administrator on 2018/1/6.
 */

public abstract class BasePresenter<T extends IView> implements IPresenter<T> {
    protected T mView;
    @Override
    public void attachView(T view) {
        this.mView=view;
    }

    @Override
    public void detachView() {
        if (this.mView!=null)
            mView=null;
    }

    @Override
    public T getView() {
        return mView;
    }
}
