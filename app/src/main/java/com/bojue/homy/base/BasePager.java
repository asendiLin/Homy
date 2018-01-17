package com.bojue.homy.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by Xie on 2018/1/12.
 * Pager类的基类
 */

public abstract class BasePager  {

    /**
     * 上下文
     */
    public final Context context;
    /**
     * 代表各个详情页面的视图
     */
    public View rootView;

    public BasePager(Context context){
        this.context = context;
        rootView = initView();
    }

    public abstract View initView();

    public void initData(){
    }
}
