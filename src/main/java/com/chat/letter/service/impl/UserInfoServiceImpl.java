package com.chat.letter.service.impl;

import java.util.List;

import com.chat.letter.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.letter.dao.UserInfoMapper;
import com.chat.letter.po.UserInfo;

/**
 * 用户信息实现类
 * @author wulinli
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoMapper mapper;
	
	public int insert(UserInfo userInfo){
		return mapper.insertSelective(userInfo);
	}
	
	public List<UserInfo> getAll(){
		List<UserInfo> datas = mapper.selectAll();
		return datas;
	}

	@Override
	public UserInfo getUserInfoByUserId(int userId) {
		return mapper.selectByUserId(userId);
	}

	@Override
	public List<UserInfo> getUserInfoByConditions(UserInfo userInfo) {
		return mapper.selectUserInfoByConditions(userInfo);
	}

	@Override
	public int update(UserInfo userInfo) {
		return mapper.update(userInfo);
	}
}
