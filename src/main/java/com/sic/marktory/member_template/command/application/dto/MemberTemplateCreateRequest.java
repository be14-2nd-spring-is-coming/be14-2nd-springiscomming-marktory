package com.sic.marktory.member_template.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberTemplateCreateRequest {
    private String title;
    private String content;
    private String writtenDate;
    private String visibility;
    private Long repositoryId;
}
