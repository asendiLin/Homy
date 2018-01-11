package com.bojue.homy.entity;

/**
 * Created by lizheng on 2018/1/9.
 */

public class CommentBean {
    private String imgUrl;
    private String name;
    private String data;
    private String comment;

    public CommentBean(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public CommentBean(String imgUrl, String name, String data, String comment) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.data = data;
        this.comment = comment;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }

    public String getComment() {
        return comment;
    }

}
