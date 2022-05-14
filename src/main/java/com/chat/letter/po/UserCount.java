package com.chat.letter.po;

import java.util.Date;

/**
 * 用户账户信息
 */
public class UserCount {

    //表ID
    private Integer id;
    //用户ID
    private Integer userId;
    //用户币种数量
    private Integer userCoinSum;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserCoinSum() {
        return userCoinSum;
    }

    public void setUserCoinSum(Integer userCoinSum) {
        this.userCoinSum = userCoinSum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
