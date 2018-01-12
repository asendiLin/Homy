package com.bojue.homy.model.home;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.MarkerBean;
import com.bojue.homy.model.IModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/1/12.
 */

public interface IHomeModel extends IModel {
    /**
     * 从服务端获取需求冒泡
     * @param uId
     * @return
     */
    Observable<BaseEntity<List<MarkerBean>>> getMarker(int uId);


}
