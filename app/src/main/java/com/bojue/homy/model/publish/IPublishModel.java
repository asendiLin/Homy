package com.bojue.homy.model.publish;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.PublishBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lizheng on 2018/1/8.
 * 发布需求model的接口
 */

public interface IPublishModel {

    /*提交发布需求数据
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
    Observable<BaseEntity<List<PublishBean>>> submitPublishContent(int uId,String price,String phoneNum,String needType,String startTime,String endTime,String needContent,String latitude,String longitude);

}
