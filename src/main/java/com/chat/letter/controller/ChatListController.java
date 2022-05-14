package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.datasource.ann.Slave;
import com.chat.letter.po.ChatList;
import com.chat.letter.service.ChatListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;

/**
 * 聊天记录列表controller
 * @author  wulinli
 * @date 20220424
 */
@RestController
@RequestMapping("chatList")
public class ChatListController {

    private Logger logger = LoggerFactory.getLogger(ChatListController.class);
    
    @Autowired
    ChatListService chatListService;

    /**
     * 查询用户的所有聊天列表
     * @param userId 用户id
     * @return
     */
    @Slave
    @Transactional
    @GetMapping("/getAll")
    public Object queryChatListByUserId(@RequestParam("userId") Integer userId){
        try{
            if(userId != null){
                return ResultMessage.success(chatListService.getChatListsByUserId(userId));
            }
        }catch (Exception e){
            logger.error("[queryChatListByUserId]查询用户聊天列表失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("查询用户聊天列表失败！");
    }

    /**
     * 删除或是拉黑单条聊天列表
     * @param id 聊天列表id
     * @return
     */
    @Master
    @Transactional
    @GetMapping("/delete")
    public Object deleteChatListById(@RequestParam("id") Integer id){
        try{
            if(id != null){
                return ResultMessage.success(chatListService.deleteById(id));
            }
        }catch (Exception e){
            logger.error("[deleteChatInfoById]删除单条聊天列表失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("删除单条聊天列表！");
    }

    /**
     * 添加单条聊天列表
     * @param params 聊天列表
     * @return
     */
    @Master
    @Transactional
    @PostMapping("/add")
    public Object addChatList(@RequestBody HashMap<String,Object> params){
        try{
            if(params != null && params.size() > 0){
                ChatList chatList = new ChatList();
                int userIdMaster = Integer.parseInt(params.get("userIdMaster").toString());
                int userIdCustomer = Integer.parseInt(params.get("userIdCustomer").toString());
                chatList.setUserIdMaster(userIdMaster);
                chatList.setUserIdCustomer(userIdCustomer);
                chatList.setStatus(1);//默认有效
                chatList.setCreateTime(new Date());
                chatList.setUpdateTime(new Date());
                return ResultMessage.success(chatListService.addChatList(chatList));
            }
        }catch (Exception e){
            logger.error("[addChatList]添加单条聊天列表失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("添加单条聊天列表失败！");
    }
}
