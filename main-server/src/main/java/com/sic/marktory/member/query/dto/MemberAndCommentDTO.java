package com.sic.marktory.member.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class MemberAndCommentDTO {
    private String nickname;
    private String content;
    private String writtenDate;
}
