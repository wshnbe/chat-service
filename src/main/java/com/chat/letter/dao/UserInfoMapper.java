package com.chat.letter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.chat.letter.po.UserInfo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户信息Mapper
 */
@Mapper
public interface UserInfoMapper {

	List<UserInfo> selectAll();
	UserInfo selectByUserId(@RequestParam("userId") int userId);
	List<UserInfo> selectUserInfoByConditions(UserInfo userInfo);
	int insertSelective(UserInfo userInfo);
	int update(UserInfo userInfo);
}
