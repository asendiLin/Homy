package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.PublishBean;

import java.util.List;
import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * Created by lizheng on 2018/1/12.
 * 设置发布需求的网络请求接口
 */

public interface PublishService {

        /*提交发布需求数据方法
        *
         @Field("") int uId,   用户ID
         @Field("") String price,   价格
         @Field("") String phoneNum,  手机号码
         @Field("") String needType , 需求类型
         @Field("") String startTime, 开始时间
         @Field("") String endTime,   结束时间
         @Field("") String needContent,  需求详情
         @Field("") String latitude,   纬度
         @Field("") String longitude);  经度
        *
        */
        @POST("")
        Observable<BaseEntity<List<PublishBean>>> submitPublishContent(@Field("") int uId,
                                                                       @Field("") String price,
                                                                       @Field("") String phoneNum,
                                                                       @Field("") String needType ,
                                                                       @Field("") String startTime,
                                                                       @Field("") String endTime,
                                                                       @Field("") String needContent,
                                                                       @Field("") String latitude,
                                                                       @Field("") String longitude);

}
