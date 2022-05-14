package com.chat.letter.po;

import java.util.Date;

public class UserInfo {

    //用户ID
    private Integer userId;
    //用户名称
    private String userName;
    //用户密码
    private String userPwd;
    //用户类型：1-普通用户；2-主播用户
    private Integer userType;
    //用户性别：1-男；2-女
    private Integer userSex;
    //用户手机
    private String userPhone;
    //用户签名
    private String userCom;
    //用户状态：1-可用；0：注销
    private Integer userStatus;
    //用户是否在线：1-在线；0-离线
    private Integer userOnline;
    //用户创建时间
    private Date createTime;
    //用户最近一次修改时间
    private Date updateTime;
    //用户头像地址
    private String userHeadPic;
    //vip类型 默认0 不是
    private Integer vipType;
    //vip名称
    private String vipName;
    //vip开通时间
    private Date vipCreateTime;
    //vip结束时间
    private Date vipEndTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCom() {
        return userCom;
    }

    public void setUserCom(String userCom) {
        this.userCom = userCom;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserOnline() {
        return userOnline;
    }

    public void setUserOnline(Integer userOnline) {
        this.userOnline = userOnline;
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

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }

    public Integer getVipType() {
        return vipType;
    }

    public void setVipType(Integer vipType) {
        this.vipType = vipType;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public Date getVipCreateTime() {
        return vipCreateTime;
    }

    public void setVipCreateTime(Date vipCreateTime) {
        this.vipCreateTime = vipCreateTime;
    }

    public Date getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(Date vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }
}
