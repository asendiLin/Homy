package com.bojue.homy.presenter.find;

import com.bojue.homy.entity.NeedItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizheng on 2018/1/8.
 */

public class FindNeedPresenterText extends AbstractFindNeedPresenter {
    @Override
    public void loadNeed(String type, String uId, int page) {
        List<NeedItem> mNeedItems = new ArrayList<>();
        NeedItem need1 = new NeedItem("1月1日","阿森第1","1");
        mNeedItems.add(need1);
        NeedItem need2 = new NeedItem("1月2日","阿森第2","2");
        mNeedItems.add(need2);
//        NeedItem need3 = new NeedItem("1月3日","阿森第3","3");
//        mNeedItems.add(need3);
//        NeedItem need4 = new NeedItem("1月4日","阿森第4","4");
//        mNeedItems.add(need4);
//        NeedItem need5 = new NeedItem("1月5日","阿森第5","5");
//        mNeedItems.add(need5);

        getView().showNeedItems(mNeedItems);
    }
}
