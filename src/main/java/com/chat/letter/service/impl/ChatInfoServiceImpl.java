package com.chat.letter.service.impl;

import com.chat.letter.dao.ChatInfoMapper;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.datasource.ann.Slave;
import com.chat.letter.po.ChatInfo;
import com.chat.letter.service.ChatInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 聊天记录服务
 * @author wulinli
 * @date 20200430
 */
@Service
public class ChatInfoServiceImpl implements ChatInfoService {

    @Autowired
    ChatInfoMapper chatInfoMapper;

    @Override
    public List<ChatInfo> getChatInfosByUserId(int userId) {
        ChatInfo chatInfo = new ChatInfo();
        chatInfo.setUserIdReciver(userId);
        chatInfo.setStatus(1);
        return chatInfoMapper.selectChatInfoByConditions(chatInfo);
    }

    @Override
    public int deleteById(int id) {
        return chatInfoMapper.updateStatus(id);
    }

    @Override
    public int addChatInfo(ChatInfo chatInfo) {
        return chatInfoMapper.insertSelective(chatInfo);
    }
}
