package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.datasource.ann.Slave;
import com.chat.letter.po.ChatInfo;
import com.chat.letter.service.ChatInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 聊天记录controller
 * @author  wulinli
 * @date 20220424
 */
@RestController
@RequestMapping("chat")
public class ChatController {

    private Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    ChatInfoService chatInfoService;

    /**
     * 查询用户的所有聊天记录
     * @param userId 用户id
     * @return
     */
    @Slave
    @GetMapping("/getAll")
    public Object queryChatInfosByUserId(@RequestParam("userId") Integer userId){
        try{
            if(userId != null){
                return ResultMessage.success(chatInfoService.getChatInfosByUserId(userId));
            }
        }catch (Exception e){
            logger.error("[queryChatListByUserId]查询用户聊天记录失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("查询用户聊天记录失败！");
    }

    /**
     * 删除单条聊天记录
     * @param id 聊天记录id
     * @return
     */
    @Master
    @Transactional
    @GetMapping("/delete")
    public Object deleteChatInfoById(@RequestParam("id") Integer id){
        try{
            if(id != null){
                return ResultMessage.success(chatInfoService.deleteById(id));
            }
        }catch (Exception e){
            logger.error("[deleteChatInfoById]删除单条聊天记录失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("删除单条聊天记录失败！");
    }

    /**
     * 添加单条聊天记录
     * @param params 聊天记录信息
     * @return
     */
    @Master
    @PostMapping("/add")
    public Object addChatInfo(@RequestBody HashMap<String,Object> params){
        try{
            if(params != null && params.size() > 0){
                ChatInfo chatInfo = new ChatInfo();
                int userIdSender = Integer.parseInt(params.get("userIdSender").toString());
                int userIdReciver = Integer.parseInt(params.get("userIdReciver").toString());
                String text = params.get("text").toString();
                chatInfo.setUserIdSender(userIdSender);
                chatInfo.setUserIdReciver(userIdReciver);
                chatInfo.setStatus(1);//默认有效
                chatInfo.setChatType(1);//默认文字类型
                chatInfo.setChatText(text);
                chatInfo.setCreateTime(new Date());
                return ResultMessage.success(chatInfoService.addChatInfo(chatInfo));
            }
        }catch (Exception e){
            logger.error("[addChatInfo]添加单条聊天记录失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("添加单条聊天记录失败！");
    }
}
