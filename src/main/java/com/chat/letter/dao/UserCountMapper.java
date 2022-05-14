package com.chat.letter.dao;

import com.chat.letter.po.UserCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户账户Mapper
 */
@Mapper
public interface UserCountMapper {

    int insert(UserCount userCount);
    int update(UserCount userCount);
    UserCount queryUserCount(int userId);
}
