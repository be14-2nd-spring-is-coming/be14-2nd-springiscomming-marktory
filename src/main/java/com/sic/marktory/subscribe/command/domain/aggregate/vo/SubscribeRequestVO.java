package com.sic.marktory.subscribe.command.domain.aggregate.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SubscribeRequestVO {

    @JsonProperty("subscriberId")
    private Long subscriberId;  // 구독하는 사람 (현재 로그인한 사용자)

    @JsonProperty("subscriberId")
    private Long subscribedId;  // 구독 대상 (상대방)
    private boolean isNotification;  // 알림 설정 여부

    public SubscribeRequestVO(Long subscriberId, Long subscribedId, boolean isNotification) {
        this.subscriberId = subscriberId;
        this.subscribedId = subscribedId;
        this.isNotification = isNotification;
    }
}
