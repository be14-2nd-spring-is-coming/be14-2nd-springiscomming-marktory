package com.sic.marktory.member.command.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class MemberDTO {
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String birthday;
    private String image;
    private Boolean isTerms;
}
