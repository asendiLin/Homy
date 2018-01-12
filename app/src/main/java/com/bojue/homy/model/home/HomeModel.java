package com.bojue.homy.model.home;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.MarkerBean;
import com.bojue.homy.service.HomeService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/12.
 */

public class HomeModel extends BaseModel implements IHomeModel {
    private HomeService mService=this.createService(HomeService.class);


    @Override
    public Observable<BaseEntity<List<MarkerBean>>> getMarker(int uId) {
        return mService.getMarker(uId);
    }
}
