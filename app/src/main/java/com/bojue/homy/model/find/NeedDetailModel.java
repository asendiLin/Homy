package com.bojue.homy.model.find;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.NeedDetailBean;
import com.bojue.homy.service.FindNeedService;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/15.
 * 获取需求详情的Model最终实现类
 */

public class NeedDetailModel extends BaseModel implements INeedDetailModel {
    private FindNeedService mService=this.createService(FindNeedService.class);
    @Override
    public Observable<BaseEntity<NeedDetailBean>> getNeedDetail(String id) {
        return mService.getNeedDetail(id)
                .compose(this.<BaseEntity<NeedDetailBean>>setThread());
    }

    @Override
    public Observable<BaseEntity<String>> accept(String nId, String uId) {
        return mService.accept(nId, uId)
                .compose(this.<BaseEntity<String>>setThread());
    }
}
