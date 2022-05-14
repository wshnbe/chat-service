package com.chat.letter.po;

import java.util.Date;

/**
 * 订单信息
 * @author wulinli
 * @date 20220430
 */
public class OrderInfo {

    //订单ID
    private Integer orderd;
    //订单编号
    private String orderCode;
    //收费项目id
    private Integer costId;
    //用户id
    private Integer userId;
    //订单消费金额
    private Double orderCount;
    //订单状态 1-有效 0-无效
    private Integer orderStatus;
    //订单消费用户币种数
    private Integer userCoinCount;
    //创建时间
    private Date createTime;

    public Integer getOrderd() {
        return orderd;
    }

    public void setOrderd(Integer orderd) {
        this.orderd = orderd;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Double getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Double orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getUserCoinCount() {
        return userCoinCount;
    }

    public void setUserCoinCount(Integer userCoinCount) {
        this.userCoinCount = userCoinCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
