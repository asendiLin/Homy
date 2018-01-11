package com.bojue.homy.presenter.community;

import com.bojue.homy.base.BasePresenter;
import com.bojue.homy.view.fragment.community.ICommunityView;

/**
 * Created by lizheng on 2018/1/8.
 * 社区的Presenter的抽象类
 */

public abstract class AbstractCommunityPresenter extends BasePresenter<ICommunityView> {

    //显示社区心情
    public abstract void loadCommunity(int page);

    //提交社区心情
    public abstract void submitCommunityFeeling(int uId,String imagUrl,String feelingContent);

    //显示点赞
    public abstract  void  loadThumbUp(int cId);

}
