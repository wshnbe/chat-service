package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.datasource.ann.Slave;
import com.chat.letter.po.CostInfo;
import com.chat.letter.service.CostInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 *  版本相关Controller
 * @author wulinli
 * @date 20220424
 */
@RestController
@RequestMapping("/cost")
public class CostController {

    private Logger logger = LoggerFactory.getLogger(CostController.class);

    @Autowired
    CostInfoService costInfoService;

    /**
     * 下载所有收费项目
     * @return
     */
    @Slave
    @GetMapping("/getAll")
    public Object getCostInfos(){
        try{
           return ResultMessage.success(costInfoService.query());
        }catch (Exception e){
            logger.error("[getCostInfos]查询失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("查询失败！");
    }

    /**
     * 新增收费项目
     * @param params
     * @return
     */
    @Master
    @PostMapping("/add")
    public Object addCostInfo(@RequestBody HashMap<String,Object> params){
        try{
            if(params != null && params.size() > 0){
                CostInfo costInfo = new CostInfo();
                Integer costType = Integer.parseInt(params.get("costType").toString());
                String costName = params.get("costName").toString();
                Double amount = Double.parseDouble(params.get("amount").toString());
                costInfo.setCostType(costType);
                costInfo.setCostName(costName);
                costInfo.setAmount(amount);
                costInfo.setCreateTime(new Date());
                int num = costInfoService.insert(costInfo);
                if(num > 0 ){
                    logger.info("[addCostInfo]新增收费项目成功！");
                    return ResultMessage.success();
                }
            }
        }catch (Exception e){
            logger.error("[addCostInfo]新增收费项目失败！",e.getMessage(),e);
        }
        return ResultMessage.error();
    }

    /**
     * 修改收费项目
     * @param params
     * @return
     */
    @Master
    @PostMapping("/update")
    public Object updateCostInfo(@RequestBody HashMap<String,Object> params){
        try{
            if(params != null && params.size() > 0){
                CostInfo costInfo = new CostInfo();
                Object id = params.get("id");
                Object costName = params.get("costName");
                Object amount = params.get("amount");
                Object costStatus = params.get("costStatus");
                if(id == null){
                    return ResultMessage.errorStr("id不可为空！");
                }
                costInfo.setCostId(Integer.parseInt(id.toString()));
                if(costName != null){
                    costInfo.setCostName(costName.toString());
                }
                if(amount != null){
                    costInfo.setAmount(Double.parseDouble(amount.toString()));
                }
                if(costStatus != null){
                    costInfo.setCostStatus(Integer.parseInt(costStatus.toString()));
                }
                int num = costInfoService.update(costInfo);
                if(num > 0 ){
                    logger.info("[updateCostInfo]修改收费项目成功！");
                    return ResultMessage.successStr("修改收费项目成功!");
                }
            }
        }catch (Exception e){
            logger.error("[updateCostInfo]修改收费项目失败！",e.getMessage(),e);
        }
        return ResultMessage.error();
    }
}
