package com.chat.letter.service;

import com.chat.letter.po.CostInfo;

import java.util.List;

public interface CostInfoService {

    int insert(CostInfo costInfo);
    int update(CostInfo costInfo);
    List<CostInfo> query();
}
