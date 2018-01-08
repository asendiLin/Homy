package com.bojue.homy.model.community;

import com.bojue.homy.base.BaseEntity;
import com.bojue.homy.entity.CommunityBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by lizheng on 2018/1/8.
 * 社区Model的接口
 */

public interface ICommunityModel {
    Observable<BaseEntity<List<CommunityBean>>> loadCommunity(int page);

}
