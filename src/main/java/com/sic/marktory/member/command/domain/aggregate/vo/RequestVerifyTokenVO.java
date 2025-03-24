package com.sic.marktory.member.command.domain.aggregate.vo;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RequestVerifyTokenVO {
    private String email;
    private String token;
}
