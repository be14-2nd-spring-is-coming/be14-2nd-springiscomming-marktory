package com.sic.marktory.member.command.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class EmailTokenVerifyDTO {
    private String email;
    private String token;
    private LocalDateTime expirationTime;
    /* 설명. 인증 메세지 (성공, 실패하면 어떤 실패인지(시간 만료, 토큰 불일치) */
    private String verifyMessage;
    private boolean isVerified;
}
