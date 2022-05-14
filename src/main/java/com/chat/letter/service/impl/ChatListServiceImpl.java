package com.chat.letter.service.impl;

import com.chat.letter.dao.ChatInfoMapper;
import com.chat.letter.dao.ChatListMapper;
import com.chat.letter.po.ChatInfo;
import com.chat.letter.po.ChatList;
import com.chat.letter.service.ChatListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 聊天列表服务
 * @author wulinli
 * @date 20200430
 */
@Service
public class ChatListServiceImpl implements ChatListService {

    @Autowired
    ChatListMapper chatListMapper;

    @Override
    public List<ChatList> getChatListsByUserId(int userId) {
        ChatList chatList = new ChatList();
        chatList.setUserIdMaster(userId);
        chatList.setStatus(1);
        return chatListMapper.selectChatListByConditions(chatList);
    }

    @Override
    public int deleteById(int id) {
        return chatListMapper.updateStatus(id);
    }

    @Override
    public int addChatList(ChatList chatList) {
        return chatListMapper.insertSelective(chatList);
    }
}
