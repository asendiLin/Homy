package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.MarkerBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/1/12.
 * 首页的Service
 */

public interface HomeService {
    /**
     * 获取需求冒泡
     * @param uId :用户id
     * @return
     */
    @GET("")
    Observable<BaseEntity<List<MarkerBean>>> getMarker(int uId);

}
