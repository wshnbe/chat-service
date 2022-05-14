package com.chat.letter.service;

import com.chat.letter.po.VedioInfo;

import java.util.List;

public interface VedioInfoService {

    int insert(VedioInfo vedioInfo);
    int update(VedioInfo vedioInfo);
    List<VedioInfo> query(VedioInfo vedioInfo);
}
