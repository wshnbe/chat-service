package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.common.util.CodeUtils;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.datasource.ann.Slave;
import com.chat.letter.po.OrderInfo;
import com.chat.letter.service.OrderInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 订单、支付Controller
 * @author wulinli
 * @date 20220424
 */
@RestController
@RequestMapping("/order")
public class OrderInfoController {

    private Logger logger = LoggerFactory.getLogger(OrderInfoController.class);

    @Autowired
    OrderInfoService orderInfoService;

    /**
     * 查询用户所有订单
     * @param userId 用户id
     * @return
     */
    @Slave
    @PostMapping("/getAll")
    public Object queryOrdersByUserId(@RequestParam("userId") Integer userId){
        try{
            if(userId != null){
                return ResultMessage.success(orderInfoService.getOrderInfoByOrderId(userId));
            }
        }catch (Exception e){
            logger.error("[queryChatListByUserId]查询用户订单列表失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("查询用户订单列表失败！");
    }

    /**
     * 查看订单详情
     * @param orderId 订单orderId
     * @return
     */
    @Slave
    @PostMapping("/detail")
    public Object queryOrderByOrderId(@RequestParam("orderId") Integer orderId){
        try{
            if(orderId != null){
                return ResultMessage.success(orderInfoService.getOrderInfoByOrderId(orderId));
            }
        }catch (Exception e){
            logger.error("[queryChatListByUserId]查询用户订单详情失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("查询用户订单详情失败！");
    }

    /**
     * 新增订单
     * @param params 订单参数
     * @return
     */
    @Master
    @Transactional
    @PostMapping("/add")
    public Object addOrder(@RequestBody HashMap<String,Object> params){
        try{
            if(params != null && params.size() > 0){
                OrderInfo orderInfo = new OrderInfo();
                Integer userId = Integer.parseInt(params.get("userId").toString());
                Integer costId = Integer.parseInt(params.get("costId").toString());
                Double amount = Double.parseDouble(params.get("amount").toString());
                Integer orderCoinCount = Integer.parseInt(params.get("amount").toString()) * 10;
                String orderCode = CodeUtils.getOrderIdByUUId(userId);//用户编号
                orderInfo.setOrderCode(orderCode);
                orderInfo.setOrderCount(amount);
                orderInfo.setUserCoinCount(orderCoinCount);
                orderInfo.setUserId(userId);
                orderInfo.setCostId(costId);
                orderInfo.setOrderStatus(1);//有效
                orderInfo.setCreateTime(new Date());
                int num = orderInfoService.addOrderInfo(orderInfo);
                if(num > 0 ){
                    logger.info("[addOrder]新增订单成功！");
                    return ResultMessage.success();
                }
            }
        }catch (Exception e){
            logger.error("[addOrder]新增订单失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("新增订单失败！");
    }

    /**
     * 支付功能
     * @param params
     * @return
     */
    public Object payOrder(@RequestBody HashMap<String,Object> params){
        return null;
    }

}
