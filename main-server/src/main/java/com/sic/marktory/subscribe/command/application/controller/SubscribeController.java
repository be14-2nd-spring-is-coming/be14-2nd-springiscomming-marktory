package com.sic.marktory.subscribe.command.application.controller;

import com.sic.marktory.subscribe.command.application.service.SubscribeService;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeRequestVO;
import com.sic.marktory.subscribe.command.domain.aggregate.vo.SubscribeResponseVO;
import com.sic.marktory.subscribe.common.exception.AlreadysubscribeException;
import com.sic.marktory.subscribe.common.exception.SubscribeException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Subscribe Command", description = "구독 요청, 구독 취소, 구독자/피구독자 조회")
@RestController("subscribeCommandController")
@RequestMapping("/api/subscribe")

// API 요청 처리
public class SubscribeController {

    private final SubscribeService subscribeService;

    public SubscribeController(@Qualifier("subscribeCommandService") SubscribeService subscribeService) {
        this.subscribeService = subscribeService;
    }

    // 구독 요청
    @Operation(
            summary = "구독 요청",
            description = """
        특정 사용자가 다른 사용자를 구독합니다.
        - `subscriberId`: 구독을 요청하는 사용자
        - `subscribedId`: 구독 대상 사용자
        - 성공 시 201 CREATED 응답과 함께 구독 정보가 반환됩니다.
        - 이미 구독 중이면 409 CONFLICT, 자기 자신을 구독하거나 잘못된 요청이면 400 BAD REQUEST 반환됩니다.
        """
    )
    @PostMapping("/{subscriberId}/{subscribedId}")
    public ResponseEntity<?> subscribe(
            @PathVariable Long subscriberId,
            @PathVariable Long subscribedId
    ) {
        try {
            SubscribeRequestVO requestVO = new SubscribeRequestVO(subscriberId, subscribedId, true);
            SubscribeResponseVO responseVO = subscribeService.subscribe(requestVO);

            // 구독 성공
            return ResponseEntity.status(HttpStatus.CREATED).body(responseVO);
        } catch (SubscribeException e) {

            // 구독 실패 (자기 자신, 존재하지 않는 회원 구독 시 등)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (AlreadysubscribeException e) {
            
            // 구독 충돌 (중복 구독 시)
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // 구독 취소
    @Operation(
            summary = "구독 취소",
            description = """
        구독 관계를 해지합니다.
        - `subscriberId`: 구독을 해지하려는 사용자
        - `subscribedId`: 구독 대상 사용자
        - 성공 시 200 OK 응답과 메시지를 반환합니다.
        - 잘못된 요청이면 400 BAD REQUEST 응답이 반환됩니다.
        """
    )
    @DeleteMapping("/{subscriberId}/{subscribedId}")
    public ResponseEntity<String> unsubscribe(
            @PathVariable Long subscriberId,
            @PathVariable Long subscribedId
    ) {
        try {
            subscribeService.unsubscribe(subscriberId, subscribedId);
            return ResponseEntity.status(HttpStatus.OK).body("구독 취소 완료!");
        } catch (SubscribeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    // 내가 구독한 사람
    @Operation(
            summary = "구독중인 유저 조회",
            description = """
        해당 사용자가 구독 중인 사용자 목록을 조회합니다.
        - `subscriberId`를 통해 내가 구독 중인 사람들을 확인합니다.
        - 성공 시 구독 대상 정보 목록이 200 OK 응답으로 반환됩니다.
        """
    )
    @GetMapping("/my-subscriptions/{subscriberId}")
    public ResponseEntity<?> getMySubscriptions(@PathVariable Long subscriberId){
        try {
            List<SubscribeResponseVO> subscriptions = subscribeService.getMySubscriptions(subscriberId);
            return ResponseEntity.ok(subscriptions);
        } catch (SubscribeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }



    // 나를 구독한 사람
    @Operation(
            summary = "내 구독자 조회",
            description = """
        나를 구독한 사용자 목록을 조회합니다.
        - `subscribedId`를 통해 나의 구독자 목록을 확인합니다.
        - 성공 시 구독자 정보 목록이 200 OK 응답으로 반환됩니다.
        """
    )
    @GetMapping("/my-subscribers/{subscribedId}")
    public ResponseEntity<?> getMySubscribers(@PathVariable Long subscribedId) {
        try {
            List<SubscribeResponseVO> subscribers  = subscribeService.getMySubscribers(subscribedId);
            return ResponseEntity.ok(subscribers);
        } catch (SubscribeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    // 구독 알림 전체 변경 (구독한 모든 대상의 알림을 'N'으로 설정)
    // ! 예외처리 생각..
    @Operation(
            summary = "구독 알림 전체 변경",
            description = """
        구독자가 구독한 모든 대상의 알림 설정을 비활성화(OFF)합니다.
        - 해당 기능은 알림을 'N'으로 일괄 설정합니다.
        - 성공 시 200 OK와 함께 안내 메시지를 반환합니다.
        """
    )
    @PatchMapping("/notification/{subscriberId}")
    public ResponseEntity<String> patchNotification(@PathVariable Long subscriberId) {
        try {
            subscribeService.updateNotification(subscriberId);
            return ResponseEntity.status(HttpStatus.OK).body("구독 알림이 전체 OFF 되었습니다.");
        } catch (SubscribeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
