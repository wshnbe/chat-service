package com.chat.letter.service.impl;

import com.chat.letter.dao.OrderInfoMapper;
import com.chat.letter.po.OrderInfo;
import com.chat.letter.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Override
    public List<OrderInfo> getOrdersByUserId(Integer userId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderStatus(1);
        orderInfo.setUserId(userId);
        return orderInfoMapper.selectOrderInfoByConditions(orderInfo);
    }

    @Override
    public OrderInfo getOrderInfoByOrderId(Integer orderId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderStatus(1);
        orderInfo.setOrderd(orderId);
        List<OrderInfo> list = orderInfoMapper.selectOrderInfoByConditions(orderInfo);
        if(list != null && list.size() > 0) return list.get(0);
        return null;
    }

    @Override
    public int addOrderInfo(OrderInfo orderInfo) {
        return orderInfoMapper.insertSelective(orderInfo);
    }
}
