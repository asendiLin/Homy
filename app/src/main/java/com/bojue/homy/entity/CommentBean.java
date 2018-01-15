package com.bojue.homy.entity;

/**
 * Created by lizheng on 2018/1/9.
 */

public class CommentBean {
    private String imgUrl;
    private String name;
    private String data;
    private String comment;
    private boolean reply = false;
    private String repliedName;

    public String getRepliedName() {
        return repliedName;
    }

    public void setRepliedName(String repliedName) {
        this.repliedName = repliedName;
    }


    public CommentBean(String name, String data, boolean reply, String repliedName) {
        this.name = name;
        this.data = data;
        this.comment = comment;
        this.reply = reply;
        this.repliedName = repliedName;
    }

    public CommentBean(String imgUrl, String name, String data, String comment, boolean reply) {
        this.imgUrl = imgUrl;
        this.name = name;
        this.data = data;
        this.comment = comment;
        this.reply = reply;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReply(boolean reply) {
        this.reply = reply;
    }

    public boolean isReply() {
        return reply;
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
