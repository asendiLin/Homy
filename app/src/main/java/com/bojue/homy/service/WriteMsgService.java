package com.bojue.homy.service;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.WriteMsgBean;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import com.bojue.homy.base.BaseEntity;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Xie on 2018/1/13.
 * 编辑个人信息的Service
 */

public interface WriteMsgService {

    @FormUrlEncoded
    @POST("hemy/user/update")
    Observable<BaseEntity<List<WriteMsgBean>>> submitMessageContent(@Field("nickname") String name,@Field("sex") int gender,@Field("userId") String Id);
}
