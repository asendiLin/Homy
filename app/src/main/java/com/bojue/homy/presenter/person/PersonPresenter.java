package com.bojue.homy.presenter.person;

import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.model.person.demand.IDemandModel;
import com.bojue.homy.model.person.demand.DemandModel;
import com.bojue.homy.model.person.order.IOrderModel;
import com.bojue.homy.model.person.order.OrderModel;

import java.util.List;

/**
 * Created by Administrator on 2018/1/7.
 * 个人中心的Presenter
 */

public class PersonPresenter extends AbstractPersonPresenter {

    private IDemandModel mDemandModel;
    private IOrderModel mOrderModel;

    public PersonPresenter(){
        mDemandModel = new DemandModel();
        mOrderModel = new OrderModel();
    }

    @Override
    public void loadDemand(int page) {
        mDemandModel.loadDemand(page)
                .subscribe(new BaseObserver<List<PersonBean>>() {
                    @Override
                    public void onSuccess(List<PersonBean> data) {
                        getView().initDemand(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });

    }
    @Override
    public void loadOrder(int page) {
        mOrderModel.loadOrder(page)
                .subscribe(new BaseObserver<List<PersonBean>>() {
                    @Override
                    public void onSuccess(List<PersonBean> data) {
                        getView().initOrder(data);
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });
    }
}
