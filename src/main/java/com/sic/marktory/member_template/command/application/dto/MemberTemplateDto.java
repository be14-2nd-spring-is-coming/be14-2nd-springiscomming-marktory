package com.sic.marktory.member_template.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberTemplateDto {
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
