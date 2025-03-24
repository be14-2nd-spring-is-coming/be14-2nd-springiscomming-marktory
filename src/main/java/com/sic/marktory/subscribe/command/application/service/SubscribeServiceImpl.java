package com.sic.marktory.subscribe.command.application.service;

import com.sic.marktory.member.command.domain.aggregate.entity.MemberEntity;
import com.sic.marktory.member.command.domain.repository.MemberRepository;
import com.sic.marktory.subscribe.command.domain.aggregate.entity.SubscribeEntity;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeRequestVO;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeResponseVO;
import com.sic.marktory.subscribe.command.domain.repository.SubscribeRepository;
import com.sic.marktory.subscribe.common.exception.AlreadysubscribeException;
import com.sic.marktory.subscribe.common.exception.SubscribeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("subscribeCommandService")
@RequiredArgsConstructor
@Transactional
public class SubscribeServiceImpl implements SubscribeService{

    private final SubscribeRepository subscribeRepository;
    private final MemberRepository memberRepository;

    // 구독하기
    @Override
    public SubscribeResponseVO subscribe(SubscribeRequestVO requestVO) {
        // 본인 구독 예외 처리
        if (requestVO.getSubscriberId().equals(requestVO.getSubscribedId())) {
            throw new SubscribeException("자기 자신을 구독할 수 없습니다.");
        }

        // 구독 중복 예외 처리
        if (subscribeRepository.existsBySubscriberIdAndSubscribedId(
                requestVO.getSubscriberId(), requestVO.getSubscribedId())) {
            throw new AlreadysubscribeException("이미 구독한 회원입니다.");
        }

        // 멤버 정보 가져오기
        MemberEntity subscriber = memberRepository.findById(requestVO.getSubscriberId())
                .orElseThrow(() -> new SubscribeException("구독자를 찾을 수 없습니다."));
        MemberEntity subscribed = memberRepository.findById(requestVO.getSubscribedId())
                .orElseThrow(() -> new SubscribeException("구독 대상을 찾을 수 없습니다."));

        // 구독 엔티티 생성
        SubscribeEntity subscribeEntity = new SubscribeEntity(
                subscriber,
                subscribed,
                requestVO.isNotification() ? 'Y' : 'N'
        );

        // 구독 정보 저장
        subscribeRepository.save(subscribeEntity);

        // 응답 객체 반환
        return new SubscribeResponseVO(subscribeEntity);
    }

    // 구독 취소
    @Override
    public void unsubscribe(Long subscriberId, Long subscribedId) {
        // 본인 구독 예외 처리
        if (subscriberId.equals(subscribedId)) {
            throw new SubscribeException("자기 자신을 구독 취소할 수 없습니다.");
        }

        // 구독 정보가 없을 때
        if (!subscribeRepository.existsBySubscriberIdAndSubscribedId(subscriberId, subscribedId)) {
            throw new SubscribeException("구독 정보가 존재하지 않습니다.");
        }

        // ! 블랙이나 탈퇴된 회원의 예외 처리도 진행?

        // 구독 데이터 삭제
        subscribeRepository.deleteBySubscriberIdAndSubscribedId(subscriberId, subscribedId);
    }

}
