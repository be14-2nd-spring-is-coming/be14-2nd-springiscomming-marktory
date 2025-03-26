package com.sic.marktory.subscribe.command.domain.aggregate.vo;

import com.sic.marktory.subscribe.command.domain.aggregate.entity.SubscribeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SubscribeResponseVO {
    private Long subscriberId;
    private Long subscribedId;
    private boolean isNotification;

    // SubscribeEntity를 기반으로 VO 생성
    public SubscribeResponseVO(SubscribeEntity subscribeEntity) {
        this.subscriberId = subscribeEntity.getSubscriber().getId();
        this.subscribedId = subscribeEntity.getSubscribed().getId();
        this.isNotification = subscribeEntity.getIsNotification() == 'Y';
    }
}
