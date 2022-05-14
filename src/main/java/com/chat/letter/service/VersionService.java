package com.chat.letter.service;

import com.chat.letter.po.VersionInfo;

public interface VersionService {


    /**
     * 根据用户当前版本查询是否是当前版本
     * @param currUserVersion 用户当前版本
     * @return
     */
    VersionInfo compareByUserCurrVersion(String currUserVersion);

    /**
     * 新增当前版本信息
     * @param versionInfo
     * @return
     */
    int addVersionInfo(VersionInfo versionInfo);


    /**
     * 根据用户当前版本查询是否是当前版本
     * @param currUserVersion 用户当前版本
     * @return
     */
    VersionInfo getByUserCurrVersion();
}
