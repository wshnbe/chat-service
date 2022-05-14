package com.chat.letter.po;

import java.util.Date;

/**
 * 用户聊天列表类
 */
public class ChatList {

    //表ID
    private Integer id;
    //主id用户
    private Integer userIdMaster;
    //客id用户
    private Integer userIdCustomer;
    //列表拉黑：1-有效，0-拉黑
    private Integer status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIdMaster() {
        return userIdMaster;
    }

    public void setUserIdMaster(Integer userIdMaster) {
        this.userIdMaster = userIdMaster;
    }

    public Integer getUserIdCustomer() {
        return userIdCustomer;
    }

    public void setUserIdCustomer(Integer userIdCustomer) {
        this.userIdCustomer = userIdCustomer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
