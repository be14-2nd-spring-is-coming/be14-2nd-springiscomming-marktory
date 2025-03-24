package com.sic.marktory.subscribe.command.application.controller;

import com.sic.marktory.subscribe.command.application.service.SubscribeService;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeRequestVO;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeResponseVO;
import com.sic.marktory.subscribe.common.exception.SubscribeException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("subscribeCommandController")
@RequestMapping("/api/subscribe")

// API 요청 처리
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(@Qualifier("subscribeCommandService") SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    // 구독 요청
    @PostMapping("/{subscriberId}/{subscribedId}")
    public ResponseEntity<?> subscribe(
            @PathVariable Long subscriberId,
            @PathVariable Long subscribedId
    ) {
        try {
            SubscribeRequestVO requestVO = new SubscribeRequestVO(subscriberId, subscribedId, true);
            SubscribeResponseVO responseVO = subscribeService.subscribe(requestVO);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseVO);
        } catch (SubscribeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    // 구독 취소
    //@DeleteMapping("/{subscriberId}/{subscribedId}")


    // 내가 구독한 사람
    //@GetMapping("/my-subscriptions/{subscriberId}")


    // 나를 구독한 사람
    //@GetMapping("/my-subscribers/{subscribedId}")


    // 구독 알림 전체 변경 (구독한 모든 대상의 알림을 'N'으로 설정)
    //@PatchMapping("/notification/{subscriberId}")


}
