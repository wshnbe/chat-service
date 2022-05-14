package com.chat.letter.po;

import java.util.Date;

public class VedioInfo {

    //视频Id
    private Integer vedioId;
    //视频发送方
    private Integer userIdSend;
    //视频接收方
    private Integer userIdRecive;
    //状态：0-结束；1-未结束
    private Integer status;
    //视频时长：秒
    private Integer vedioDura;
    //视频剩余时长
    private Integer remainDura;
    //创建时间
    private Date createTime;
    //结束时间
    private Date endTime;

    public Integer getVedioId() {
        return vedioId;
    }

    public void setVedioId(Integer vedioId) {
        this.vedioId = vedioId;
    }

    public Integer getUserIdSend() {
        return userIdSend;
    }

    public void setUserIdSend(Integer userIdSend) {
        this.userIdSend = userIdSend;
    }

    public Integer getUserIdRecive() {
        return userIdRecive;
    }

    public void setUserIdRecive(Integer userIdRecive) {
        this.userIdRecive = userIdRecive;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVedioDura() {
        return vedioDura;
    }

    public void setVedioDura(Integer vedioDura) {
        this.vedioDura = vedioDura;
    }

    public Integer getRemainDura() {
        return remainDura;
    }

    public void setRemainDura(Integer remainDura) {
        this.remainDura = remainDura;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
