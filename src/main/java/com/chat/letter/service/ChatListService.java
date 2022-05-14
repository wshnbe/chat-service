package com.chat.letter.service;

import com.chat.letter.po.ChatList;

import java.util.List;

public interface ChatListService {

    /**
     * 查询用户所有聊天列表
     * @param userId
     * @return
     */
    List<ChatList> getChatListsByUserId(int userId);

    /**
     * 删除单条用户聊天列表
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 添加用户聊天列表
     * @param ChatList
     * @return
     */
    int addChatList(ChatList ChatList);
}
