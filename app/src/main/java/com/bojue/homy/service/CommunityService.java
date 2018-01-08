package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.CommunityBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lizheng on 2018/1/8.
 * 设置列表数据网络请求的接口
 */

public interface CommunityService {
    @GET("")
    Observable<BaseEntity<List<CommunityBean>>> loadCommunity(@Query("page") int page);
}
