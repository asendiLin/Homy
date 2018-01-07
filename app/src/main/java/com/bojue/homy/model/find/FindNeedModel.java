package com.bojue.homy.model.find;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.NeedItem;
import com.bojue.homy.service.FindNeedService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/7.
 * 发现需求的Model
 */

public class FindNeedModel extends BaseModel implements IFindNeedModel {
    FindNeedService mService=this.createService(FindNeedService.class);
    @Override
    public Observable<BaseEntity<List<NeedItem>>> loadNeed(String type, String uId, int page) {
        return mService.loadNeed(type, uId, page)
                .compose(this.<BaseEntity<List<NeedItem>>>setThread());
    }
}
