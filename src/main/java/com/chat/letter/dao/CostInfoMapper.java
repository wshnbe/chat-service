package com.chat.letter.dao;

import com.chat.letter.po.CostInfo;
import com.chat.letter.po.VersionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CostInfoMapper {

    int insertSelective(CostInfo costInfo);
    int update(CostInfo costInfo);
    List<CostInfo> selectByConditions(CostInfo costInfo);
    List<CostInfo> selectAll();
}
