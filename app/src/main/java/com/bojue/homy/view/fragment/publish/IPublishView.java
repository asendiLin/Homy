package com.bojue.homy.view.fragment.publish;

import com.bojue.homy.view.IView;

/**
 * Created by lizheng on 2018/1/8.
 * 发布需求的view接口
 */

public interface IPublishView extends IView{

    //发布需求成功的方法
    void publishSuccess();

    //发布需求失败的方法
    void publishFail();
}
