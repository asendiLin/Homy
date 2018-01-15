package com.bojue.homy.presenter.community;


import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.model.community.CommunityModel;
import com.bojue.homy.model.community.ICommunityModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by lizheng on 2018/1/8.
 * 社区的Presenter
 */

public class CommunityPresenter extends AbstractCommunityPresenter {
    private ICommunityModel mModel;
    public CommunityPresenter() {
        mModel = new CommunityModel();
    }

   //获取心情列表数据
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
   //发送心情数据操作
    @Override
    public void submitCommunityFeeling(int uId, String imagUrl, String feelingContent,String mDate) {
        mModel.submitCommunityFeeling(uId, imagUrl, feelingContent,mDate)
                .subscribe(new BaseObserver<List<CommunityBean>>() {
                    @Override
                    public void onSuccess(List<CommunityBean> data) {
                        getView().initCommunity(data);
                        getView().sendSuccess();
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        getView().sendFail();
                    }
                });
    }

    //获取点赞数据
    @Override
    public void loadThumbUp(final int cId, final int uId) {
        mModel.loadThumbUp(cId,uId)
                .subscribe(new BaseObserver<List<CommunityBean>>() {
                    @Override
                    public void onSuccess(List<CommunityBean> data) {
                        getView().thumbUpSuccess(cId);
                    }

                    @Override
                    public void onFail(Throwable throwable) {
                        getView().thumbUpFail();
                    }
                });
    }

}
