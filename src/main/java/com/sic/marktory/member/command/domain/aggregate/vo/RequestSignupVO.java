package com.sic.marktory.member.command.domain.aggregate.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RequestSignupVO {
    private String email;
    private String name;
    private String password;
    private String nickname;
    private String birthday;
    private String image;
    private Boolean isTerms;
}
