package com.bojue.homy.model.person.order;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.service.OrderService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Xie on 2018/1/12.
 * 我的订单之Model
 */

public class OrderModel extends BaseModel implements IOrderModel {
    OrderService mService = this.createService(OrderService.class);
    @Override
    public Observable<BaseEntity<List<PersonBean>>> loadOrder(int page) {
        return mService.loadDemand(page);
    }
}
