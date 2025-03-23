package com.sic.marktory.subscribe.query.controller;

import com.sic.marktory.subscribe.query.dto.MemberDTO;
import com.sic.marktory.subscribe.query.service.SubscribeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 조회 API
@RestController("subscribeQueryController")
@RequestMapping("/api/subscribe")
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    // 내가 구독한 회원들 조회
    @GetMapping("/subscriber/{memberId}")
    public List<MemberDTO> getSubscribed(@PathVariable("memberId") Long memberId){
        return subscribeService.getSubscribedMembers(memberId);
    }

    // 나를 구독한 회원들 조회
    @GetMapping("/subscribed/{memberId}")
    public List<MemberDTO> getSubscriber(@PathVariable("memberId") Long memberId){
        return subscribeService.getSubscriberMembers(memberId);
    }
}
