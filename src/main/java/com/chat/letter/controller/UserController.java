package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.common.util.FileNameUtils;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.datasource.ann.Slave;
import com.chat.letter.po.PicInfo;
import com.chat.letter.po.UserCount;
import com.chat.letter.po.UserInfo;
import com.chat.letter.service.PicInfoService;
import com.chat.letter.service.UserCountService;
import com.chat.letter.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String defaultPicName = "/file/default.jpeg";

	@Autowired
	UserInfoService userInfoService;

	@Autowired
	UserCountService userCountService;

	@Autowired
	PicInfoService picInfoService;

	@Value("${web.upload-path}")
	private String uploadPath;

	@Master
	@Transactional
	@PostMapping(value="/register")
	public Object register(@RequestBody HashMap<String,Object> params){
		try{
			if(params != null && params.size() > 0){
				UserInfo userInfo = new UserInfo();
				UserCount userCount = new UserCount();
				String userPhone = params.get("userPhone").toString();
				if(!StringUtils.isEmpty(userPhone)){
					UserInfo tmp = new UserInfo();
					tmp.setUserPhone(userPhone);
					List<UserInfo> lists = userInfoService.getUserInfoByConditions(tmp);
					if(lists != null && lists.size() > 0){
						return ResultMessage.errorStr("手机号已注册！");
					}
				}
				String userPwd = params.get("userPwd").toString();
				String userName = params.get("userName").toString();
				Integer userSex = Integer.parseInt(params.get("userSex").toString());
				userInfo.setUserPhone(userPhone);
				userInfo.setUserName(userName);
				userInfo.setUserPwd(userPwd);
				userInfo.setUserSex(userSex);
				userInfo.setUserType(1);//默认普通用户
				userInfo.setUserStatus(1);//默认可用
				userInfo.setUserOnline(0);//默认离线
				userInfo.setUserHeadPic(defaultPicName);
				userInfo.setCreateTime(new Date());
				userInfo.setUpdateTime(new Date());
				//新增用户
				int returnNumUserInfo = userInfoService.insert(userInfo);
				userCount.setUserId(userInfo.getUserId());
				userCount.setUserCoinSum(0);
				userCount.setCreateTime(new Date());
				userCount.setUpdateTime(new Date());
				//新增用户账户
				int returnNumUserCount = userCountService.insert(userCount);
				if(returnNumUserInfo > 0 && returnNumUserCount > 0){
					logger.info("[register]注册成功！");
					return ResultMessage.success();
				}
			}
		}catch (Exception e){
			logger.error("[register]注册失败！",e.getMessage(),e);
			return ResultMessage.error();
		}
		logger.error("[register]注册失败！");
		return ResultMessage.error();
	}
	
	@PostMapping(value="/queryByConditions")
	public Object queryByConditions(@RequestBody HashMap<String,Object> params){
		return null;
	}

	/**
	 * 根据用户ID-查询用户信息
	 * @param userId
	 * @return
	 */
	@Slave
	@GetMapping(value="/queryByUserId")
	public Object queryByUserId(@RequestParam("userId") Integer userId){
		try{
			if(userId != null){
				return ResultMessage.success(userInfoService.getUserInfoByUserId(userId));
			}
			return ResultMessage.errorStr("查询不存在！");
		}catch (Exception e){
			logger.error("[queryByUserId]查询失败！",e.getMessage(),e);
			return ResultMessage.error();
		}
	}

	/**
	 * 根据用户手机查询-查询用户信息
	 * @param userPhone
	 * @return
	 */
	@Slave
	@GetMapping(value="/queryByUserPhone")
	public Object queryByUserPhone(@RequestParam("userPhone") String userPhone){
		try{
			if(!StringUtils.isEmpty(userPhone)){
				UserInfo userInfo = new UserInfo();
				userInfo.setUserPhone(userPhone);
				userInfo.setUserStatus(1);
				List<UserInfo> lists = userInfoService.getUserInfoByConditions(userInfo);
				if(lists != null && lists.size() > 0){
					return ResultMessage.success(lists.get(0));
				}
			}
			return ResultMessage.errorStr("查询不存在！");
		}catch (Exception e){
			logger.error("[queryByUserPhone]查询失败！",e.getMessage(),e);
			return ResultMessage.error();
		}
	}

	/**
	 * 用户修改信息
	 * @param params
	 * @return
	 */
	@Master
	@PostMapping(value="/update")
	public Object userUpdate(@RequestBody HashMap<String,Object> params){
		try{
			if(params != null && params.size() > 0){
				Object userId = params.get("userId");
				Object userCom = params.get("userCom");
				Object userName = params.get("userName");
				if(userId != null){
					UserInfo userInfo = new UserInfo();
					userInfo.setUserId(Integer.parseInt(userId.toString()));
					if(userName != null){
						userInfo.setUserName(userName.toString());
					}
					if(userCom != null){
						userInfo.setUserCom(userCom.toString());
					}
					int num = userInfoService.update(userInfo);
					if(num > 0){
						logger.info("[userUpdate]用户信息修改成功！");
						return ResultMessage.successStr("用户信息修改成功！");
					}
				}
			}
		}catch (Exception e){
			logger.error("[userUpdate]用户信息修改异常：",e.getMessage(),e);
		}
		logger.info("[userUpdate]用户信息修改失败！");
		return ResultMessage.errorStr("用户信息修改失败！");
	}


	/**
	 * 注销用户
	 * @param userId
	 * @return
	 */
	@Master
	@GetMapping(value="/cancel")
	public Object deleteOne(@RequestParam("userId") Integer userId){
		try{
			if(userId != null){
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(userId);
				userInfo.setUserStatus(0);//设置为不可用
				userInfo.setUserOnline(0);//设置为离线
				int num = userInfoService.update(userInfo);
				if(num > 0){
					logger.info("[deleteOne]用户注销成功！");
					return ResultMessage.successStr("用户注销成功！");
				}
			}
			logger.info("[deleteOne]用户注销失败！");
			return ResultMessage.errorStr("用户注销失败！");
		}catch (Exception e){
			logger.error("[deleteOne]用户注销失败！",e.getMessage(),e);
			return ResultMessage.errorStr("用户注销失败");
		}
	}

	/**
	 * 上传图片到本地，通过path
	 * @return
	 */
	@Master
	@PostMapping("/upload")
	public Object upload(@RequestParam("userId") int userId, @RequestPart("files") MultipartFile[] files){
		try{
			if(files.length > 0 && !StringUtils.isEmpty(userId)){
				//遍历文件
				for (int i=0;i< files.length;i++) {
					MultipartFile multipartFile = files[i];
					if(!multipartFile.isEmpty()){
						String originalFilename = multipartFile.getOriginalFilename();
						String newFileName = FileNameUtils.getFileName(userId,i);
						String updateLoadPath = FileNameUtils.getFilePath(userId,uploadPath);
						String filePath = updateLoadPath + newFileName;
						//判断文件夹是否存在
						File folder = new File(updateLoadPath);
						if(!folder.isDirectory()){
							folder.isDirectory();
						}
						logger.info("[upload]文件原始名称：{},修改后名称：{}",originalFilename,newFileName);
						logger.info("[upload]文件保存路径：{}",filePath);
						multipartFile.transferTo(new File(filePath));
						//写入表中
						PicInfo picInfo = new PicInfo();
						picInfo.setPicAdd(updateLoadPath);
						picInfo.setPicName(newFileName);
						picInfo.setUserId(userId);
						picInfo.setUserId(userId);
						picInfo.setPicType(2);//默认简介图片
						picInfo.setStatus(1);//默认可用
						picInfo.setCreateTime(new Date());
						picInfo.setUpdateTime(new Date());
						int num = picInfoService.insert(picInfo);
						if(num > 0){
							logger.info("[upload]图传上传成功！");
							return ResultMessage.successStr("图传上传成功！");
						}
					}
				}
			}
			return ResultMessage.errorStr("无图片上传！");
		}catch (Exception e){
			logger.error("[upload]userId={}上传失败！",userId,e.getMessage(),e);
			return ResultMessage.errorStr("上传失败！");
		}
	}
}
