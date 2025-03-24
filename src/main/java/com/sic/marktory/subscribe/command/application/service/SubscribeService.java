package com.sic.marktory.subscribe.command.application.service;


import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeRequestVO;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeResponseVO;

public interface SubscribeService {
    // 구독하기
    SubscribeResponseVO subscribe(SubscribeRequestVO requestVO);
}
