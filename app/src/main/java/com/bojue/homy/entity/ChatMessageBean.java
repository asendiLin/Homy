package com.bojue.homy.entity;

/**
 * Created by Administrator on 2018/1/16.
 * 聊天消息实体
 */

public class ChatMessageBean {
    private String content;//内容
    private String sender;//发送者
    private String receiver;//接收者
    private int direction;//接收/发送

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
