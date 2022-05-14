package com.chat.letter.controller;

import com.chat.letter.common.msg.ResultMessage;
import com.chat.letter.datasource.ann.Master;
import com.chat.letter.datasource.ann.Slave;
import com.chat.letter.po.VersionInfo;
import com.chat.letter.service.VersionService;
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

/**
 *  版本相关Controller
 * @author wulinli
 * @date 20220424
 */
@RestController
@RequestMapping("/version")
public class VersionController {


    private Logger logger = LoggerFactory.getLogger(VersionController.class);

    @Autowired
    VersionService versionService;

    @Value("${version.upload-path}")
    private String uploadPath;

    /**
     * 对比最新版本并返回最新下载连接
     * @param userVersion 用户手机app版本
     * @return
     */
    @Slave
    @GetMapping("/getCurrVersion")
    public Object getLastestVersion(@RequestParam("userVersion") String userVersion){
        try{
            if(!StringUtils.isEmpty(userVersion)){
                return ResultMessage.success(versionService.compareByUserCurrVersion(userVersion));
            }
        }catch (Exception e){
            logger.error("[queryChatListByUserId]对比版本失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("对比版本失败！");
    }

    /**
     * 根据下载地址生成二维码
     * @return
     */
    @Slave
    @GetMapping("/getMapCode")
    public Object createMapCode(){
        VersionInfo versionInfo = versionService.getByUserCurrVersion();
        return null;
    }

    /**
     * 上传新版本
     * @return
     */
    @Master
    @Transactional
    @PostMapping("/upload")
    public Object upload(@RequestPart("file") MultipartFile multipartFile){
        try{
            if(multipartFile != null){
                String originalFilename = multipartFile.getOriginalFilename();
                String filePath = uploadPath + originalFilename;
                //判断文件夹是否存在
                File folder = new File(uploadPath);
                if(!folder.isDirectory()){
                    folder.isDirectory();
                }
                logger.info("[upload]文件原始名称：{},文件保存路径：{}",originalFilename,filePath);
                multipartFile.transferTo(new File(filePath));
                //写入表中
                VersionInfo versionInfo = new VersionInfo();
                versionInfo.setVersion(originalFilename);
                versionInfo.setDownloadPath(filePath);
                versionInfo.setCreateTime(new Date());
                versionService.addVersionInfo(versionInfo);
                return ResultMessage.successStr("上传成功！");
            }
        }catch (Exception e){
            logger.error("[upload]上传失败！",e.getMessage(),e);
        }
        return ResultMessage.errorStr("上传失败！");
    }
}
