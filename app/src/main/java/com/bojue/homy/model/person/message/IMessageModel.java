package com.bojue.homy.model.person.message;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.WriteMsgBean;

import java.util.List;
import io.reactivex.Observable;

/**
 * Created by Xie on 2018/1/13.
 */

public interface IMessageModel {

    Observable<BaseEntity<List<WriteMsgBean>>> submitMessageContent(String name,int gender,String Id);

}
