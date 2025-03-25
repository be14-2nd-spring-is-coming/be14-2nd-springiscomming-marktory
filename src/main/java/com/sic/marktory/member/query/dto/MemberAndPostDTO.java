package com.sic.marktory.member.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberAndPostDTO {
    private String title;
    private String nickname;
    private String content;
}
