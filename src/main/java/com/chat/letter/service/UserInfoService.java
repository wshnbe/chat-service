package com.chat.letter.service;

import com.chat.letter.po.UserInfo;

import java.util.List;

public interface UserInfoService {

    int insert(UserInfo userInfo);
    List<UserInfo> getAll();
    UserInfo getUserInfoByUserId(int userId);
    /**条件查询*/
    List<UserInfo> getUserInfoByConditions(UserInfo userInfo);
    int update(UserInfo userInfo);
}
