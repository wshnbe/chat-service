package com.chat.letter.service;

import com.chat.letter.po.UserCount;

public interface UserCountService {

    int insert(UserCount count);
    int update(UserCount count);
    UserCount queryUserCount(int userId);
}
