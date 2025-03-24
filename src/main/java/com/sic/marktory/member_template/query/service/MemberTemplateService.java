package com.sic.marktory.member_template.query.service;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import com.sic.marktory.member_template.query.mapper.MemberTemplateMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberTemplateService {
    // 특정 회원의 템플릿 조회 (본인)
    public List<MemberTemplateDTO> findMemberTemplates(Long memberId);

    // 특정 회원의 공개된 템플릿 조회
    public List<MemberTemplateDTO> findMemberTemplatePublicAll(Long memberId);

    // TODO: 구독중인 회원의 템플릿 조회
}
