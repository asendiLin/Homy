package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.PersonBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/1/7.
 * 个人中心Service
 */

public interface OrderService {
    /**
     * 我的需求的列表
     * @param page 页数
     * @return
     */
    @GET("")
    Observable<BaseEntity<List<PersonBean>>>loadDemand(@Query("page") int page);
}
