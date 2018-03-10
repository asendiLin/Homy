package com.bojue.homy.view.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.bojue.homy.R;
import com.bojue.homy.base.BaseFragment;
import com.bojue.homy.entity.MarkerBean;
import com.bojue.homy.listener.MyOrientationListener;
import com.bojue.homy.presenter.home.AbstractHomePresenter;
import com.bojue.homy.presenter.home.HomePresenter;
import com.bojue.homy.presenter.home.TestHomePresenter;
import com.bojue.homy.view.IView;
import com.bojue.homy.view.activity.find.NeedDetailActivity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/6.
 */

public class HomeFragment extends BaseFragment implements IHomeView {
private final static String TAG="HOME_FRAGMENT";
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private BitmapDescriptor mIcon;
    private MyLocationConfiguration.LocationMode mLocationMode;
    private MyLocationListener mLocationListener;
    private LocationClient mLocationClient;
    private MyOrientationListener mOrientationListener;
    private View mView;
    private float currentX;//当前的位置
    private double mLatitude;//纬度
    private double mLongtitude;//经度
    private boolean isFirstIn = true;
    private AbstractHomePresenter mPresenter;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container) {
        mView=inflater.inflate(R.layout.fragment_home_layout,container,false);
//        mView = View.inflate(getContext(), R.layout.fragment_home_layout, null);
        mMapView = mView.findViewById(R.id.mapView);
        mBaiduMap = mMapView.getMap();
        mIcon = BitmapDescriptorFactory.fromResource(R.mipmap.navi_map_gps_locked);//定位的图标
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.zoomBy(20f);//设置比例
        mBaiduMap.setMapStatus(mapStatusUpdate);
        return mView;
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter=new TestHomePresenter();
        mPresenter.attachView(this);
        mPresenter.getMarker(1);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initLocation();
    }

    @Override
    public void onStart() {
        mBaiduMap.setMyLocationEnabled(true);
        if (!mLocationClient.isStarted()) {
            mLocationClient.start();
        }
        mOrientationListener.start();

        initListener();

        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBaiduMap.setMyLocationEnabled(false);
        mLocationClient.stop();
        //停止传感器
        mOrientationListener.stop();
        isFirstIn=true;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        mPresenter.detachView();
    }
    BaiduMap.OnMarkerClickListener onMarkerClickListener =new BaiduMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            //获取点击的图标信息
            //显示详情
            Bundle bundle=marker.getExtraInfo();
            MarkerBean markerBean= (MarkerBean) bundle.getSerializable("markerBean");
            Log.i(TAG, "onMarkerClick: Latitude:"+markerBean.getLatitude());
            Intent intent=new Intent(getActivity(), NeedDetailActivity.class);
            //toDo:传送需求的id
            startActivity(intent);
            mBaiduMap.removeMarkerClickListener(onMarkerClickListener);
            mBaiduMap.clear();
            return false;
        }
    };
    private void initListener() {
        //覆盖物的点击监听
//        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                //获取点击的图标信息
//                //显示详情
//                Bundle bundle=marker.getExtraInfo();
//                MarkerBean markerBean= (MarkerBean) bundle.getSerializable("markerBean");
//                Log.i(TAG, "onMarkerClick: Latitude:"+markerBean.getLatitude());
//                Intent intent=new Intent(getActivity(), NeedDetailActivity.class);
//                //toDo:传送需求的id
//                startActivity(intent);
//                return false;
//            }
//        });


        mBaiduMap.setOnMarkerClickListener(onMarkerClickListener);


        //点击地图监听
        mBaiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

            }

            @Override
            public boolean onMapPoiClick(MapPoi mapPoi) {
                return false;
            }
        });
    }

    /**
     * 初始化定位
     */
    private void initLocation() {
        mLocationMode = MyLocationConfiguration.LocationMode.NORMAL;
        mLocationClient = new LocationClient(getContext());
        mLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(mLocationListener);

        //配置信息
        LocationClientOption option = new LocationClientOption();
        option.setCoorType("ba9011");
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setScanSpan(1000);//每秒更新一次

        mLocationClient.setLocOption(option);
        mOrientationListener = new MyOrientationListener(getContext());
        mOrientationListener.setOnOrientationListener(new MyOrientationListener.OnOrientationListener() {
            @Override
            public void onOrientationChanged(float x) {
                currentX = x;
            }
        });

    }
//添加需求冒泡
    @Override
    public void addOverlays(List<MarkerBean> markerBeanList) {
        mBaiduMap.clear();
        LatLng latLng=null;
        Marker marker=null;
        OverlayOptions options;
        for (MarkerBean markerBean: markerBeanList) {
            //经纬度
            latLng=new LatLng(markerBean.getLatitude(),markerBean.getLongitude());
            //图标,按照类型给图标
            BitmapDescriptor bd=BitmapDescriptorFactory.fromResource(R.mipmap.maker);

            options=new MarkerOptions().position(latLng).icon(bd).zIndex(5);

            marker= (Marker) mBaiduMap.addOverlay(options);
            Bundle arg=new Bundle();
            arg.putSerializable("markerBean",markerBean);

            marker.setExtraInfo(arg);
        }
        MapStatusUpdate msu=MapStatusUpdateFactory.newLatLng(latLng);
        mBaiduMap.setMapStatus(msu);
    }

    private class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            MyLocationData data = new MyLocationData.Builder()
                    .direction(currentX)
                    .accuracy(bdLocation.getRadius())
                    .latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude())
                    .build();
            mBaiduMap.setMyLocationData(data);

            //设置图标
            MyLocationConfiguration configuration = new
                    MyLocationConfiguration(mLocationMode, true, mIcon);
            mBaiduMap.setMyLocationConfigeration(configuration);
            //更新经纬度
            mLatitude = bdLocation.getLatitude();
            mLongtitude = bdLocation.getLongitude();
//            Toast.makeText(getActivity(), "Latitude:"+ mLatitude+" Longtitude:"+mLongtitude, Toast.LENGTH_SHORT).show();
//            la:21.150479
//            lo:110.306183
            if (isFirstIn) {
                centerToMyLocation();
                isFirstIn = false;
            }
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    /**
     * 显示到当前的位置
     */
    private void centerToMyLocation() {
        LatLng latLng = new LatLng(mLatitude, mLongtitude);
//        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(latLng);
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(latLng,20f);
        mBaiduMap.animateMapStatus(mapStatusUpdate);

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading(boolean isSuccess) {

    }
}
