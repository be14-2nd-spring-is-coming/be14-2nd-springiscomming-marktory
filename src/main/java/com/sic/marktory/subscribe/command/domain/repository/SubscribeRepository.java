package com.sic.marktory.subscribe.command.domain.repository;

import com.sic.marktory.subscribe.command.domain.aggregate.entity.SubscribeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface SubscribeRepository extends JpaRepository<SubscribeEntity, Long> {

    // 중복 체크 (구독 여부 확인)
    boolean existsBySubscriberIdAndSubscribedId(Long subscriberId, Long subscribedId);

    // 구독 취소
    void deleteBySubscriberIdAndSubscribedId(Long subscriberId, Long subscribedId);

    // 내가 구독한 사람들 목록 조회
    List<SubscribeEntity> findAllBySubscriberId(Long subscriberId);

    // 나를 구독한 사람들 목록 조회

}
