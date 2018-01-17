package com.bojue.homy.model.person.message;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseModel;
import com.bojue.homy.entity.WriteMsgBean;
import com.bojue.homy.service.WriteMsgService;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Xie on 2018/1/13.
 */

public class MessageModel extends BaseModel implements IMessageModel {
    WriteMsgService mService = this.createService(WriteMsgService.class);
    @Override
    public Observable<BaseEntity<List<WriteMsgBean>>> loadMessage(String name, String gender, int number) {
        return mService.loadMessage(name,gender,number);
    }
}
