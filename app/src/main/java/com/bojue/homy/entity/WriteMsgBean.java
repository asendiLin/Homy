package com.bojue.homy.entity;

/**
 * Created by Xie on 2018/1/13.
 */

public class WriteMsgBean {
    private String name_msg;
    private String gender_msg;
    private int number_msg;

    public WriteMsgBean(String name_msg, String gender_msg, int number_msg) {
        this.name_msg = name_msg;
        this.gender_msg = gender_msg;
        this.number_msg = number_msg;
    }

    public String getName_msg() {
        return name_msg;
    }

    public void setName_msg(String name_msg) {
        this.name_msg = name_msg;
    }

    public String getGender_msg() {
        return gender_msg;
    }

    public void setGender_msg(String gender_msg) {
        this.gender_msg = gender_msg;
    }

    public int getNumber_msg() {
        return number_msg;
    }

    public void setNumber_msg(int number_msg) {
        this.number_msg = number_msg;
    }
}
