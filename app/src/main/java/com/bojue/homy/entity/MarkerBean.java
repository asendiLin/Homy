package com.bojue.homy.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/12.
 * 覆盖物信息
 */

public class MarkerBean implements Serializable {
    private double longitude;
    private double latitude;
    private int type;

    public MarkerBean(){}
    public MarkerBean(double longitude,double latitude){
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
