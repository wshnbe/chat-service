package com.chat.letter.dao;

import com.chat.letter.po.VedioInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VedioInfoMapper {

    int insertSelective(VedioInfo vedioInfo);
    int update(VedioInfo vedioInfo);
    List<VedioInfo> selectVedioInfoByConditions(VedioInfo vedioInfo);
}
