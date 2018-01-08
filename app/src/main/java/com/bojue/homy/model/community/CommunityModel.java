package com.bojue.homy.model.community;



import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.CommunityBean;
import com.bojue.homy.service.CommunityService;

import java.util.List;

import io.reactivex.Observable;


/**
 * Created by lizheng on 2018/1/8.
 * 社区的Model
 */

public class CommunityModel extends BaseModel implements ICommunityModel{

    CommunityService mService=this.createService(CommunityService.class);

    @Override
    public Observable<BaseEntity<List<CommunityBean>>> loadCommunity(int page) {
        return mService.loadCommunity(page);
    }
}
