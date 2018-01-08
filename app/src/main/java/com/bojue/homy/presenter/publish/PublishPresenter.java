package com.bojue.homy.presenter.publish;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.model.publish.IPublishModel;
import com.bojue.homy.model.publish.PublishModel;

/**
 * Created by lizheng on 2018/1/8.
 */

public class PublishPresenter extends AbstractPublishPresenter {
    private IPublishModel mModel;
    public PublishPresenter(){
        mModel= new PublishModel();
    }
}
