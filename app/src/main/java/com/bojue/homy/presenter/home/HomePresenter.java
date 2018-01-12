package com.bojue.homy.presenter.home;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.MarkerBean;
import com.bojue.homy.model.home.HomeModel;
import com.bojue.homy.model.home.IHomeModel;

import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 * 首页的Presenter的具体实现类
 */

public class HomePresenter extends AbstractHomePresenter {
    private IHomeModel mModel;

    public HomePresenter(){
        mModel=new HomeModel();
    }
    @Override
    public void getMarker(int uId) {
        mModel.getMarker(uId)
                .subscribe(new BaseObserver<List<MarkerBean>>() {
                    @Override
                    public void onSuccess(List<MarkerBean> data) {
                        getView().addOverlays(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });
    }
}
