package com.chat.letter.po;

import java.util.Date;

/**
 * 图片信息类
 */
public class PicInfo {

    //表ID
    private Integer id;
    //用户ID
    private Integer userId;
    //图片地址
    private String picAdd;
    //图片名称
    private String picName;
    //图片类型
    private Integer picType;
    //图片状态
    private Integer status;
    //图片创建时间
    private Date createTime;
    //图片修改时间
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

    public String getPicAdd() {
        return picAdd;
    }

    public void setPicAdd(String picAdd) {
        this.picAdd = picAdd;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public Integer getPicType() {
        return picType;
    }

    public void setPicType(Integer picType) {
        this.picType = picType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
