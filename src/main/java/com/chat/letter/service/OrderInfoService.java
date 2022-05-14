package com.chat.letter.service;

import com.chat.letter.po.OrderInfo;

import java.util.List;

public interface OrderInfoService {

    List<OrderInfo> getOrdersByUserId(Integer userId);
    OrderInfo getOrderInfoByOrderId(Integer orderId);
    int addOrderInfo(OrderInfo orderInfo);
}
