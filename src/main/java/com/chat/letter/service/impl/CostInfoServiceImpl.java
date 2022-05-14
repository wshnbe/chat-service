package com.chat.letter.service.impl;

import com.chat.letter.dao.CostInfoMapper;
import com.chat.letter.po.CostInfo;
import com.chat.letter.service.CostInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostInfoServiceImpl implements CostInfoService {

    @Autowired
    CostInfoMapper costInfoMapper;

    @Override
    public int insert(CostInfo costInfo) {
        return costInfoMapper.insertSelective(costInfo);
    }

    @Override
    public int update(CostInfo costInfo) {
        return costInfoMapper.update(costInfo);
    }

    @Override
    public List<CostInfo> query() {
        return costInfoMapper.selectAll();
    }
}
