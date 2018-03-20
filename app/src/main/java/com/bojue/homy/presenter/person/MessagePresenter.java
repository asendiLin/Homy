package com.bojue.homy.presenter.person;

import android.util.Log;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.base.BaseObserver;
import com.bojue.homy.entity.WriteMsgBean;
import com.bojue.homy.model.person.message.IMessageModel;
import com.bojue.homy.model.person.message.MessageModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Xie on 2018/3/11.
 */

public class MessagePresenter extends AbstractMessagePresenter {

    private IMessageModel messageModel;

    public MessagePresenter(){
        this.messageModel = new MessageModel();
    }


    @Override
    public void submitMessageContent(String name, int gender, String Id) {
        messageModel.submitMessageContent(name, gender, Id)
                .subscribe(new BaseObserver<List<WriteMsgBean>>() {
                    @Override
                    public void onSuccess(List<WriteMsgBean> data) {
                        getView().submitMessageContent();
                    }

                    @Override
                    public void onFail(Throwable throwable) {

                    }
                });
    }
}
