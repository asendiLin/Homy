package com.bojue.homy.presenter.publish;

/**
 * Created by lizheng on 2018/1/12.
 */

public class PublishTextPre extends AbstractPublishPresenter {
    @Override
    public void submitPublishContent(int uId, String price, String phoneNum, String needType, String startTime, String endTime, String needContent, String latitude, String longitude) {
        getView().publishSuccess();
    }
}
