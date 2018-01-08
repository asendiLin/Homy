package com.bojue.homy.presenter.community;


import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.model.community.CommunityModel;
import com.bojue.homy.model.community.ICommunityModel;

import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 * 社区的Presenter
 */

public class CommunityPresenter extends AbstractCommunityPresenter {
    private ICommunityModel mModel;
    public CommunityPresenter() {
        mModel = new CommunityModel();
    }


    @Override
    public void loadCommunity(int page) {
        mModel.loadCommunity(page)
                .subscribe(new BaseObserver<List<CommunityBean>>() {
                    @Override
                    public void onSuccess(List<CommunityBean> data) {
                        getView().initCommunity(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });
    }
}
