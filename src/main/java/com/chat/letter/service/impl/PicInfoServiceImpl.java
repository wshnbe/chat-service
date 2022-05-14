package com.chat.letter.service.impl;

import com.chat.letter.dao.PicInfoMapper;
import com.chat.letter.po.PicInfo;
import com.chat.letter.service.PicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图片实体类
 */
@Service
public class PicInfoServiceImpl implements PicInfoService {

    @Autowired
    PicInfoMapper mapper;

    @Override
    public int insert(PicInfo picInfo) {
        return mapper.insertSelective(picInfo);
    }
}
