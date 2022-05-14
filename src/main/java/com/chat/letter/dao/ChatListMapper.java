package com.chat.letter.dao;

import com.chat.letter.po.ChatList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ChatListMapper {

    int insertSelective(ChatList chatList);
    List<ChatList> selectChatListByConditions(ChatList chatList);
    int updateStatus(@RequestParam("id") int id);
}
