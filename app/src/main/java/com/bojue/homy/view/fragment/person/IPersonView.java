package com.bojue.homy.view.fragment.person;

import com.bojue.homy.entity.NeedItem;
import com.bojue.homy.entity.PersonBean;
import com.bojue.homy.entity.RegisterBean;
import com.bojue.homy.view.IView;

import java.util.List;

/**
 * Created by Xie on 2018/1/8.
 * 个人中心的view接口
 */

public interface IPersonView extends IView {

    void initDemand(List<PersonBean> demandBeanList);

    void initOrder(List<PersonBean> orderBeanList);

}
