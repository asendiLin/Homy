package com.bojue.homy.presenter.home;

import com.bojue.homy.entity.MarkerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class TestHomePresenter extends AbstractHomePresenter {
    @Override
    public void getMarker(int uId) {
        List<MarkerBean> markerBeanList=new ArrayList<>();
        MarkerBean markerBean1=new MarkerBean(110.306183,21.150479);
        MarkerBean markerBean2=new MarkerBean(110.306183,21.151479);
        MarkerBean markerBean3=new MarkerBean(110.307183,21.150479);
        MarkerBean markerBean4=new MarkerBean(110.316183,21.151479);
        MarkerBean markerBean5=new MarkerBean(110.308183,21.151479);
        markerBeanList.add(markerBean1);
        markerBeanList.add(markerBean2);
        markerBeanList.add(markerBean3);
        markerBeanList.add(markerBean4);
        markerBeanList.add(markerBean5);
        getView().addOverlays(markerBeanList);
    }
}
