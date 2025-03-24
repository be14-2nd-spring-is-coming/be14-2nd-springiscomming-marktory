package com.sic.marktory.member_template.command.application.service;

import com.sic.marktory.member_template.command.application.dto.MemberTemplateCreateRequest;
import com.sic.marktory.member_template.command.application.dto.MemberTemplateUpdateRequest;

public interface MemberTemplateService {

    // 사용자가 템플릿을 작성
    Long createMemberTemplate(MemberTemplateCreateRequest request);

    // 사용자 템플릿 수정
    void updateMemberTemplate(Long id, MemberTemplateUpdateRequest request);

    // 사용자 템플릿 삭제
    void deleteMemberTemplate(Long id);
}
