package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.po.UserInfo;
import com.chat.letter.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * 用户登录功能
 */
@RestController
@RequestMapping("")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserInfoService service;

    /**
     * 用户登录：手机号+密码
     * @return
     */
    @Master
    @Transactional
    @PostMapping("/login")
    public Object userLogin(@RequestBody HashMap<String,String> params){
        try{
            if(params != null && params.size() > 0){
                String userPhone = params.get("userPhone").toString();
                String userPwd = params.get("userPwd").toString();
                UserInfo userInfo = new UserInfo();
                userInfo.setUserPhone(userPhone);
                userInfo.setUserPwd(userPwd);
                userInfo.setUserStatus(1);
                List<UserInfo> lists = service.getUserInfoByConditions(userInfo);
                if(lists != null && lists.size() > 0){
                    logger.info("[userLogin]手机用户{}登录成功！",userPhone);
                    UserInfo queryUser = lists.get(0);
                    //设置为登录状态
                    UserInfo temp = new UserInfo();
                    temp.setUserOnline(1);//设置为在线状态
                    temp.setUserId(queryUser.getUserId());
                    service.update(temp);
                    return ResultMessage.success(queryUser);
                }
            }
        }catch (Exception e){
            logger.error("[userLogin]登录异常：",e.getMessage(),e);
        }
        logger.info("[userLogin]登录失败！");
        return ResultMessage.errorStr("登录失败！");
    }

    /**
     * 用户退出登录
     * @param userId
     * @return
     */
    @GetMapping("/out")
    public Object userOut(@RequestParam("userId") Integer userId){
        try{
            if(!StringUtils.isEmpty(userId)){
                UserInfo userInfo = new UserInfo();
                userInfo.setUserOnline(0);
                userInfo.setUserId(userId);
                int count = service.update(userInfo);
                if(count > 0){
                    logger.info("[userOut]用户Id={}退出成功！",userId);
                    return ResultMessage.successStr("退出成功！");
                }
            }
        }catch (Exception e){
            logger.error("[userOut]退出异常：",e.getMessage(),e);
        }
        logger.info("[userOut]退出失败！");
        return ResultMessage.errorStr("退出失败！");
    }
}
