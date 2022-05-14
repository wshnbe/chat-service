package com.chat.letter.dao;

import com.chat.letter.po.PicInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PicInfoMapper {

    int insertSelective(PicInfo picInfo);
}
