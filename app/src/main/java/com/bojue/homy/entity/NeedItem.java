package com.bojue.homy.entity;

/**
 * Created by Administrator on 2018/1/7.
 * 需求列表实体类
 */

public class NeedItem {
    private String imgUrl;
    private String date;
    private String content;
    private String place;
    private String username;
    private String price;

    public NeedItem(String date, String username, String price) {
        this.date = date;
        this.username = username;
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getPlace() {
        return place;
    }

    public String getUsername() {
        return username;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "NeedItem{" +
                "imgUrl='" + imgUrl + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", place='" + place + '\'' +
                ", username='" + username + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
