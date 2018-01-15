package com.bojue.homy.presenter.publish;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.entity.PublishBean;
import com.bojue.homy.model.publish.IPublishModel;
import com.bojue.homy.model.publish.PublishModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by lizheng on 2018/1/8.
 * 发布需求的presenter
 */

public class PublishPresenter extends AbstractPublishPresenter {
    private IPublishModel mModel;
    public PublishPresenter(){
        mModel= new PublishModel();
    }

    //发布需求
    @Override
    public void submitPublishContent(int uId, String price, String phoneNum, String needType, String startTime, String endTime, String needContent, String latitude, String longitude) {
        mModel.submitPublishContent(uId, price, phoneNum, needType, startTime, endTime, needContent, latitude, longitude)
                .subscribe(new BaseObserver<List<PublishBean>>() {
                    @Override
                    public void onSuccess(List<PublishBean> data) {
                        getView().publishSuccess();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        getView().publishFail();
                    }
                });
    }
}
