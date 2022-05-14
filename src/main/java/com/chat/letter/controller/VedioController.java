package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.po.VedioInfo;
import com.chat.letter.service.VedioInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 视频相关controller
 * @author wulinli
 * @date 20220424
 */
@RestController
@RequestMapping("/vedio")
public class VedioController {

    private Logger logger = LoggerFactory.getLogger(VedioController.class);

    @Autowired
    VedioInfoService vedioInfoService;

    /**
     * 查询所有结束的视频列表
     * @return
     */
    @GetMapping("/getVerdioedList")
    public Object getVedioedList(){
        return null;
    }

    /**
     * 查询所有视频中视频列表
     * @return
     */
    @GetMapping("/getVerdioingList")
    public Object getVedioingList(){
        return null;
    }

    /**
     * 查询单个结束后视频详情
     * @return
     */
    @GetMapping("/getVerdioedDetail")
    public Object getVedioedDetail(@RequestParam("id") Integer id){
        return null;
    }

    /**
     * 查询单个视频中视频详情
     * @return
     */
    @GetMapping("/getVerdioingDetail")
    public Object getVedioingDetail(@RequestParam("id") Integer id){
        return null;
    }

    /**
     * 添加视频
     * @param params
     * @return
     */
    @PostMapping("/add")
    public Object addVedio(@RequestBody HashMap<String,Object> params){
        try{
            if(params != null && params.size() > 0){
                VedioInfo vedioInfo = new VedioInfo();
                Integer userIdSend = Integer.parseInt(params.get("userIdSend").toString());
                Integer userIdRecive = Integer.parseInt(params.get("userIdRecive").toString());
                vedioInfo.setUserIdSend(userIdSend);
                vedioInfo.setUserIdRecive(userIdRecive);
                vedioInfo.setCreateTime(new Date());
                vedioInfo.setStatus(1);//默认有效
                int num = vedioInfoService.insert(vedioInfo);
                if(num > 0 ){
                    logger.info("[addVedio]新增视频成功！");
                    return ResultMessage.success(vedioInfo);
                }
            }
        }catch (Exception e){
            logger.error("[addVedio]新增视频失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("新增视频失败！");
    }

    /**
     * 视频结束
     * @param params
     * @return
     */
    @PostMapping("/update")
    public Object updateVedio(@RequestBody HashMap<String,Object> params){
        try{
            if(params != null && params.size() > 0){
                VedioInfo vedioInfo = new VedioInfo();
                Integer vedioId = Integer.parseInt(params.get("vedioId").toString());
                vedioInfo.setVedioId(vedioId);
                vedioInfo.setEndTime(new Date());//当前时间
                vedioInfo.setStatus(0);//默认有效
                int num = vedioInfoService.update(vedioInfo);
                if(num > 0 ){
                    logger.info("[updateVedio]视频结束成功！");
                    return ResultMessage.success();
                }
            }
        }catch (Exception e){
            logger.error("[updateVedio]视频结束失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("视频结束失败！");
    }
}
