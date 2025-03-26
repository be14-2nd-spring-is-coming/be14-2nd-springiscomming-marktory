package com.sic.marktory.member_template.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberTemplateUpdateRequest {
    private String title;
    private String content;
    private String visibility;
}
