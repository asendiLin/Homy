package com.bojue.homy.model.person.order;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.PersonBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/7.
 * 个人中心的Model
 */

public interface IOrderModel {
     Observable<BaseEntity<List<PersonBean>>> loadOrder(int page);
}
