package com.sic.marktory.subscribe.query.service;

import com.sic.marktory.subscribe.query.dto.MemberDTO;
import java.util.List;

// 비즈니스 로직 담당
public interface SubscribeService {
    // 내가 구독한 회원들 조회
    List<MemberDTO> findSubscribedMembers(Long memberId);

    // 나를 구독한 회원들 조회
    List<MemberDTO> findSubscriberMembers(Long memberId);
}
