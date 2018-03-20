package com.bojue.homy.presenter.person;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.activity.person.message.MessageView;

/**
 * Created by Xie on 2018/3/11.
 */

public abstract class AbstractMessagePresenter  extends BasePresenter<MessageView>{

    public abstract void submitMessageContent(String name,int gender,String Id);

}
