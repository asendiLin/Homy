package com.bojue.homy.model.person.demand;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.service.DemandService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/7.
 * 我的需求之Model
 */

public class DemandModel extends BaseModel implements IDemandModel {
    DemandService mService = this.createService(DemandService.class);
    @Override
    public Observable<BaseEntity<List<PersonBean>>> loadDemand(int page) {
        return mService.loadDemand(page);
    }
}
