package com.bojue.homy.presenter.find;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.NeedDetailBean;
import com.bojue.homy.model.find.INeedDetailModel;
import com.bojue.homy.model.find.NeedDetailModel;

/**
 * Created by Administrator on 2018/1/15.
 * 获取需求详情的Presenter层的最终实现类
 */

public class NeedDetailPresenter extends AbstractNeedDetailPresenter {

    private INeedDetailModel mModel;
    public NeedDetailPresenter(){
        mModel=new NeedDetailModel();
    }

    @Override
    public void getNeedDetail(String id) {
        mModel.getNeedDetail(id)
                .subscribe(new BaseObserver<NeedDetailBean>() {
                    @Override
                    public void onSuccess(NeedDetailBean data) {
                        getView().showNeedDetail(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });
    }

    @Override
    public void accept(String nId, String uId) {
        mModel.accept(nId, uId)
                .subscribe(new BaseObserver<String>() {
                    @Override
                    public void onSuccess(String data) {
                        getView().showAcceptResult(true);
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        getView().showAcceptResult(false);
                    }
                });
    }
}
