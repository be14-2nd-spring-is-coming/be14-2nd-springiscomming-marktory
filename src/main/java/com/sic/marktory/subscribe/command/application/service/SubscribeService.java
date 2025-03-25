package com.sic.marktory.subscribe.command.application.service;


import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeRequestVO;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeResponseVO;

import java.util.List;

public interface SubscribeService {
    // 구독하기
    SubscribeResponseVO subscribe(SubscribeRequestVO requestVO);

    // 구독 취소
    void unsubscribe(Long subscriberId, Long subscribedId);

    // 내가 구독한 사람 목록 조회
    List<SubscribeResponseVO> getMySubscriptions(Long subscriberId);

    // 나를 구독한 사람 목록 조회
    List<SubscribeResponseVO> getMySubscribers(Long subscribedId);
}
