package com.bojue.homy.base;

import com.bojue.homy.model.IModel;
import com.bojue.homy.utils.https.RetrofitFactory;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/6.
 * Model层的抽象
 */

public abstract class BaseModel implements IModel {
    /**
     * 设置线程的切换
     */
    public <T> ObservableTransformer<T,T> setThread(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 创建Service
     */
    public <T> T createService(Class<T> service){

        checkService(service);

        return RetrofitFactory.getService(service);
    }

    /**
     * 检验参数Service
     * @param service
     * @param <T>
     */
    private <T> void checkService(Class<T> service) {
        if (service==null)
            throw new NullPointerException("service must not be null!");
        if (!service.isInterface())
            throw new IllegalArgumentException("Class must be interface !");
        if (service.getInterfaces().length>0)
            throw new IllegalArgumentException("service interfaces must not extends other interface!");

    }
}
