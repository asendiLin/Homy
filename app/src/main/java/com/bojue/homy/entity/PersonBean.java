package com.bojue.homy.entity;

import android.content.Context;
import android.view.View;

import com.bojue.homy.view.IView;

/**
 * Created by Xie on 2018/1/11.
 * 个人中心的信息类
 */

public class PersonBean {
    private String type_demand;
    private String start_time_demand;
    private String end_time_demand;
    private int price_demand;
    private String finish_demand;
    private int image_Id;

    public PersonBean(String start_time_demand, String end_time_demand, int price_demand) {
        this.start_time_demand = start_time_demand;
        this.end_time_demand = end_time_demand;
        this.price_demand = price_demand;
    }

    public PersonBean(String type_demand, String start_time_demand, String end_time_demand, int price_demand, String finish_demand,int image_Id) {
        this.type_demand = type_demand;
        this.start_time_demand = start_time_demand;
        this.end_time_demand = end_time_demand;
        this.price_demand = price_demand;
        this.finish_demand = finish_demand;
        this.image_Id = image_Id;
    }

    public int getImage_Id() {
        return image_Id;
    }

    public void setImage_Id(int image_Id) {
        this.image_Id = image_Id;
    }

    public String getType_demand() {
        return type_demand;
    }

    public void setType_demand(String type_demand) {
        this.type_demand = type_demand;
    }

    public String getStart_time_demand() {
        return start_time_demand;
    }

    public void setStart_time_demand(String start_time_demand) {
        this.start_time_demand = start_time_demand;
    }

    public String getEnd_time_demand() {
        return end_time_demand;
    }

    public void setEnd_time_demand(String end_time_demand) {
        this.end_time_demand = end_time_demand;
    }

    public int getPrice_demand() {
        return price_demand;
    }

    public void setPrice_demand(int price_demand) {
        this.price_demand = price_demand;
    }

    public String getFinish_demand() {
        return finish_demand;
    }

    public void setFinish_demand(String finish_demand) {
        this.finish_demand = finish_demand;
    }


}
