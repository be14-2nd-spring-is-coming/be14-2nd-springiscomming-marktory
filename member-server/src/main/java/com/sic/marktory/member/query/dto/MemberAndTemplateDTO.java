package com.sic.marktory.member.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class MemberAndTemplateDTO {
    private String nickname;
    private String title;
    private String content;
    private String writtenDate;
    private String visibility;
    private Boolean isCopy;
}
