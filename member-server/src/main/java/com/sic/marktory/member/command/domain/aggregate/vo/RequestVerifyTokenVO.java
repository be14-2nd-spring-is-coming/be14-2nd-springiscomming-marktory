package com.sic.marktory.member.command.domain.aggregate.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RequestVerifyTokenVO {
    private String email;
    private String token;
}
