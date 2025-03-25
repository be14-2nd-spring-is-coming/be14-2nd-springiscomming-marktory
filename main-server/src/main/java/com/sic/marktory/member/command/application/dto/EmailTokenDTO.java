package com.sic.marktory.member.command.application.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class EmailTokenDTO {
    private String email;
    private String token;
    private LocalDateTime expirationTime;
}
