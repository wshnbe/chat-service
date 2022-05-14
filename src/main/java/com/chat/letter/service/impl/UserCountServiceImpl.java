package com.chat.letter.service.impl;

import com.chat.letter.dao.UserCountMapper;
import com.chat.letter.po.UserCount;
import com.chat.letter.service.UserCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户账户实现类
 */
@Service
public class UserCountServiceImpl implements UserCountService {

    @Autowired
    UserCountMapper mapper;

    @Override
    public int insert(UserCount count) {
        return mapper.insert(count);
    }

    @Override
    public int update(UserCount count) {
        return mapper.update(count);
    }

    @Override
    public UserCount queryUserCount(int userId) {
        return mapper.queryUserCount(userId);
    }
}
