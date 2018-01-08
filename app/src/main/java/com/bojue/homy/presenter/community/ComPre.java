package com.bojue.homy.presenter.community;

import com.bojue.homy.entity.CommunityBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 */

public class ComPre extends AbstractCommunityPresenter {
    @Override
    public void loadCommunity(int page) {
        List<CommunityBean> communityList=new ArrayList<>();
        CommunityBean people1 = new CommunityBean("sys001","1月3日");
        communityList.add(people1);
        CommunityBean people2 = new CommunityBean("sys002","1月4日");
        communityList.add(people2);
        CommunityBean people3 = new CommunityBean("sys003","1月5日");
        communityList.add(people3);
        CommunityBean people4 = new CommunityBean("sys004","1月6日");
        communityList.add(people4);
        CommunityBean people5 = new CommunityBean("sys005","1月7日");
        communityList.add(people5);

        getView().initCommunity(communityList);
    }
}
