package com.bojue.homy.model.publish;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.PublishBean;
import com.bojue.homy.service.PublishService;
import com.bojue.homy.view.fragment.community.ICommunityView;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lizheng on 2018/1/8.
 */

public class PublishModel extends BaseModel implements IPublishModel {

    PublishService mService =  this.createService(PublishService.class);

//提交发布需求数据
    @Override
    public Observable<BaseEntity<List<PublishBean>>> submitPublishContent(int uId, String price, String phoneNum, String needType, String startTime, String endTime, String needContent, String latitude, String longitude) {
        return mService.submitPublishContent(uId, price, phoneNum, needType, startTime, endTime, needContent, latitude, longitude).compose(this.<BaseEntity<List<PublishBean>>>setThread());
    }
}
