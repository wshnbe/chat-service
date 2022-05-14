package com.chat.letter.dao;

import com.chat.letter.po.ChatInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ChatInfoMapper {

    int insertSelective(ChatInfo chatInfo);
    List<ChatInfo> selectChatInfoByConditions(ChatInfo chatInfo);
    int updateStatus(@RequestParam("id") int id);
}
