package com.chat.letter.service;

import com.chat.letter.po.ChatInfo;

import java.util.List;

public interface ChatInfoService {

    /**
     * 查询用户所有消息
     * @param userId
     * @return
     */
    List<ChatInfo> getChatInfosByUserId(int userId);

    /**
     * 删除单条用户聊天信息
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 添加用户单条信息
     * @param chatInfo
     * @return
     */
    int addChatInfo(ChatInfo chatInfo);
}
