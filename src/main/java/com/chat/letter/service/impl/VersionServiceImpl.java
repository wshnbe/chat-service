package com.chat.letter.service.impl;

import com.chat.letter.common.util.FileNameUtils;
import com.chat.letter.dao.VersionMapper;
import com.chat.letter.po.VersionInfo;
import com.chat.letter.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    VersionMapper versionMapper;

    /**
     * 如果当前版本大于用户版本 则返回 最新版本信息
     * @param currUserVersion 用户当前版本
     * @return
     */
    @Override
    public VersionInfo compareByUserCurrVersion(String currUserVersion) {
        VersionInfo versionInfo = versionMapper.selectCurrentVersion();
        String currVersion = versionInfo.getVersion();
        boolean result = compare(currUserVersion,currVersion);
        if(result) return versionInfo;
        return null;
    }

    /**
     * 新增版本信息
     * @param versionInfo
     * @return
     */
    @Override
    public int addVersionInfo(VersionInfo versionInfo) {
        return versionMapper.insertSelective(versionInfo);
    }

    @Override
    public VersionInfo getByUserCurrVersion() {
        return versionMapper.selectCurrentVersion();
    }

    /**
     * 对比版本大小
     * @param userVersion 用户版本
     * @param version 当前最新版本
     * @return
     */
    private boolean compare(String userVersion,String version){
        Integer userVersionInt = FileNameUtils.getVersionCode(userVersion);
        Integer versionInt = FileNameUtils.getLastVersionCode(version);
        if(userVersionInt != null && versionInt != null)
            return versionInt > userVersionInt ? true : false;
        return false;
    }
}
