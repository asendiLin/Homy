package com.bojue.homy.entity;

/**
 * Created by lizheng on 2018/1/7.
 */

public class CommunityBean {
    private int communityId;
    private String name_community;
    private String date_community;
    private int ID_head_sculpture;
    private int ID_iv_community;
    private int zan_sum_community;
    private String content_community;
    //是否点赞(状态）默认false
    private boolean status;
/*
*调试用的构造方法
 */


    public CommunityBean(String name_community, String date_community) {
        this.name_community = name_community;
        this.date_community = date_community;
    }

    public CommunityBean(String name_community, String date_community, int zan_sum_community) {
        this.name_community = name_community;
        this.date_community = date_community;
        this.zan_sum_community = zan_sum_community;
    }
    public CommunityBean(String name_community, String date_community, int zan_sum_community,boolean status) {
        this.name_community = name_community;
        this.date_community = date_community;
        this.zan_sum_community = zan_sum_community;
        this.status=status;
    }
    /*---------------------------------------------------------------*/

    public CommunityBean(int communityId, String name_community, String date_community, int ID_head_sculpture, int ID_iv_community, int zan_sum_community, String content_community, boolean status) {
        this.communityId = communityId;
        this.name_community = name_community;
        this.date_community = date_community;
        this.ID_head_sculpture = ID_head_sculpture;
        this.ID_iv_community = ID_iv_community;
        this.zan_sum_community = zan_sum_community;
        this.content_community = content_community;
        this.status = status;
    }
    /*---------------------------------------------------------------*/
    /*----set方法-----*/
    public void setZan_sum_community(int zan_sum_community) {
        this.zan_sum_community = zan_sum_community;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    /*---------------------------------------------------------------*/
    public boolean isStatus() {
        return status;
    }

    /*---------------------------------------------------------------*/
    /*----get方法-----*/

    public String getName_community() {
        return name_community;
    }

    public String getDate_community() {
        return date_community;
    }

    public int getID_head_sculpture() {
        return ID_head_sculpture;
    }

    public int getID_iv_community() {
        return ID_iv_community;
    }

    public int getZan_sum_community() {
        return zan_sum_community;
    }

    public String getContent_community() {
        return content_community;
    }

    /*---------------------------------------------------------------*/
}
