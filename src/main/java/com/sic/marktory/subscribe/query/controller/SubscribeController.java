package com.sic.marktory.subscribe.query.controller;

import com.sic.marktory.subscribe.query.dto.MemberDTO;
import com.sic.marktory.subscribe.query.service.SubscribeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 조회 API
@Tag(name = "SubScribe Query", description = "구독한 회원 조회, 내 구독자 조회")
@RestController("subscribeQueryController")
@RequestMapping("/api/subscribe")
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(@Qualifier("subscribeQueryService") SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    // 내가 구독한 회원들 조회
    @Operation(
            summary = "구독한 회원 조회",
            description = """
        특정 회원이 구독하고 있는 다른 회원들의 목록을 조회합니다.
        - `memberId`를 기준으로 해당 사용자가 구독 중인 대상 목록을 반환합니다.
        - 반환 타입은 `MemberDTO` 리스트입니다.
        """
    )
    @GetMapping("/subscriber/{memberId}")
    public List<MemberDTO> getSubscribedMembers(@PathVariable("memberId") Long memberId){
        return subscribeService.findSubscribedMembers(memberId);
    }

    // 나를 구독한 회원들 조회
    @Operation(
            summary = "내 구독자 조회",
            description = """
        특정 회원을 구독 중인 회원들(구독자)의 목록을 조회합니다.
        - `memberId`를 기준으로 나를 구독 중인 회원들을 반환합니다.
        - 반환 타입은 `MemberDTO` 리스트입니다.
        """
    )
    @GetMapping("/subscribed/{memberId}")
    public List<MemberDTO> getSubscriberMembers(@PathVariable("memberId") Long memberId){
        return subscribeService.findSubscriberMembers(memberId);
    }
}
