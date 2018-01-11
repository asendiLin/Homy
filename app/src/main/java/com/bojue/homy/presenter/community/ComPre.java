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
        CommunityBean people1 = new CommunityBean("sys001","1月3日",261,false);
        communityList.add(people1);
        CommunityBean people2 = new CommunityBean("sys002","1月4日",261,true);
        communityList.add(people2);
        CommunityBean people3 = new CommunityBean("sys003","1月5日",261,false);
        communityList.add(people3);
        CommunityBean people4 = new CommunityBean("sys004","1月6日",261,true);
        communityList.add(people4);
        CommunityBean people5 = new CommunityBean("sys005","1月7日",261,true);
        communityList.add(people5);
        getView().initCommunity(communityList);
    }

    @Override
    public void submitCommunityFeeling(int uId, String imagUrl, String feelingContent) {

    }

    @Override
    public void loadThumbUp(int pageId) {
        getView().thumbUpSuccess(pageId);
    }

}
