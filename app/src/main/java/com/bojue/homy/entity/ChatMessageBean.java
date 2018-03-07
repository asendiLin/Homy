package com.bojue.homy.entity;

/**
 * Created by Administrator on 2018/1/16.
 * 聊天消息实体
 */

public class ChatMessageBean {
    private String content;//内容
    private String senderIcon;//发送者
    private String receiverIcon;//接收者
    private int direction;//接收/发送

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderIcon() {
        return senderIcon;
    }

    public void setSenderIcon(String senderIcon) {
        this.senderIcon = senderIcon;
    }

    public String getRecieverIcon() {
        return receiverIcon;
    }

    public void setReceiverIcon(String receiverIcon) {
        this.receiverIcon = receiverIcon;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
