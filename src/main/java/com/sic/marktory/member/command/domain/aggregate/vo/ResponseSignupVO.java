package com.sic.marktory.member.command.domain.aggregate.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class ResponseSignupVO {
    private String nickname;
    private String message;
}
