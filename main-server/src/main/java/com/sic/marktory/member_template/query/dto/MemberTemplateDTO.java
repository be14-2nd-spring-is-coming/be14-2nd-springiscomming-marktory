package com.sic.marktory.member_template.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class MemberTemplateDTO {
    private Long id;
    private String title;
    private String content;
    private String visibility;
    private String writtenDate;
    private String deleteDate;
    private int usageCount;
    private char isCopy;
    private Long repositoryId;
}
