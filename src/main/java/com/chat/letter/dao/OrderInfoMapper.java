package com.chat.letter.dao;

import com.chat.letter.po.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoMapper {

    int insertSelective(OrderInfo orderInfo);
    List<OrderInfo> selectOrderInfoByConditions(OrderInfo orderInfo);
}
