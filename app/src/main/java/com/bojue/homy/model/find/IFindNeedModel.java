package com.bojue.homy.model.find;

import com.bojue.homy.base.BaseEntity;

import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.NeedItem;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/7.
 * 发现需求列表的Model
 */

public interface IFindNeedModel {
    /**
     * 加载需求列表
     */
     Observable<BaseEntity<List<NeedItem>>> loadNeed(String type,String uId,int page);
}
