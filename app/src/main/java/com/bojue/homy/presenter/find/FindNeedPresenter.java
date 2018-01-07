package com.bojue.homy.presenter.find;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.NeedItem;
import com.bojue.homy.model.find.FindNeedModel;
import com.bojue.homy.model.find.IFindNeedModel;

import java.util.List;

/**
 * Created by Administrator on 2018/1/7.
 * 发现需求的Presenter
 */

public class FindNeedPresenter extends AbstractFindNeedPresenter {

    private IFindNeedModel mModel;

    public FindNeedPresenter(){
        mModel=new FindNeedModel();
    }

    @Override
    public void loadNeed(String type, String uId, int page) {
        mModel.loadNeed(type, uId, page)
                .subscribe(new BaseObserver<List<NeedItem>>() {
                    @Override
                    public void onSuccess(List<NeedItem> data) {
                        getView().showNeedItems(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }

                    @Override
                    public void onRequestEnd(boolean isSuccess) {
                        super.onRequestEnd(isSuccess);
                    }

                    @Override
                    public void onResultMsg(String msg) {
                        super.onResultMsg(msg);
                    }
                });
    }
}
