package com.sic.marktory.member_template.command.application.service;

import com.sic.marktory.member_template.command.application.dto.MemberTemplateCreateRequest;

public interface MemberTemplateService {

    // 사용자가 템플릿을 작성
    Long createMemberTemplate(MemberTemplateCreateRequest request);
}
