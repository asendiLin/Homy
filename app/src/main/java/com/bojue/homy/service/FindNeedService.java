package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.NeedDetailBean;
import com.bojue.homy.entity.NeedItem;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/1/7.
 * 发现需求Service
 */

public interface FindNeedService {
    /**
     * 请求需求列表数据
     * @param type:类型
     * @param uId:用户id
     * @param page:页码
     * @return
     */
    @GET("aaa")
    Observable<BaseEntity<List<NeedItem>>>loadNeed(@Query("") String type, @Query("") String uId,
                                                   @Query("")int page);

    /**
     * 获取需求详情
     * @param id:需求id
     * @return
     */
    @GET("")
    Observable<BaseEntity<NeedDetailBean>>getNeedDetail(@Query("")String id);

    /**
     * 接单
     * @param nId:需求id
     * @param uId:用户id
     * @return
     */
    @POST("")
    Observable<BaseEntity<String>>accept(@Field("") String nId, @Field("")String uId);
}
