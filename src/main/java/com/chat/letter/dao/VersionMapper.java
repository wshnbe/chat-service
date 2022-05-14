package com.chat.letter.dao;

import com.chat.letter.po.VersionInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VersionMapper {

    int insertSelective(VersionInfo versionInfo);
    VersionInfo selectCurrentVersion();
}
