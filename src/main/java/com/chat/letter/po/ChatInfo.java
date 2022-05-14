package com.chat.letter.po;

import java.util.Date;

/**
 * 用户聊天消息类
 */
public class ChatInfo {

    //表ID
    private Integer id;
    //用户id发送方
    private Integer userIdSender;
    //用户id接收方
    private Integer userIdReciver;
    //消息信息
    private String chatText;
    //消息状态1-有效，0-无效
    private Integer status;
    //消息类型1-文字消息
    private Integer chatType;
    //创建时间
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIdSender() {
        return userIdSender;
    }

    public void setUserIdSender(Integer userIdSender) {
        this.userIdSender = userIdSender;
    }

    public Integer getUserIdReciver() {
        return userIdReciver;
    }

    public void setUserIdReciver(Integer userIdReciver) {
        this.userIdReciver = userIdReciver;
    }

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChatType() {
        return chatType;
    }

    public void setChatType(Integer chatType) {
        this.chatType = chatType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
