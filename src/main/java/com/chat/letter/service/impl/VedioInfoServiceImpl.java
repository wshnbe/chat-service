package com.chat.letter.service.impl;

import com.chat.letter.dao.VedioInfoMapper;
import com.chat.letter.po.VedioInfo;
import com.chat.letter.service.VedioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VedioInfoServiceImpl implements VedioInfoService {

    @Autowired
    VedioInfoMapper mapper;

    @Override
    public int insert(VedioInfo vedioInfo) {
        return mapper.insertSelective(vedioInfo);
    }

    @Override
    public int update(VedioInfo vedioInfo) {
        return mapper.update(vedioInfo);
    }

    @Override
    public List<VedioInfo> query(VedioInfo vedioInfo) {
        return mapper.selectVedioInfoByConditions(vedioInfo);
    }
}
