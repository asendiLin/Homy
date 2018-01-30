package com.bojue.homy.model.find;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.NeedDetailBean;
import com.bojue.homy.model.IModel;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/15.
 * 需求详情的Model接口
 */

public interface INeedDetailModel extends IModel {
    /**
     * 获取需求详情
     * @param id
     * @return
     */
    Observable<BaseEntity<NeedDetailBean>> getNeedDetail(String id);

    /**
     * 接单
     * @param nId
     * @param uId
     * @return
     */
    Observable<BaseEntity<String>>accept(String nId,String uId);
}
