package com.sic.marktory.member_template.query.service;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import com.sic.marktory.member_template.query.mapper.MemberTemplateMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberTemplateServiceImpl implements MemberTemplateService {
    private final MemberTemplateMapper memberTemplateMapper;

    @Autowired
    public MemberTemplateServiceImpl(MemberTemplateMapper memberTemplateMapper) {
        this.memberTemplateMapper = memberTemplateMapper;
    }

    // 특정 회원의 모든 템플릿 조회 (본인)
    @Override
    public List<MemberTemplateDTO> findMemberTemplates(Long memberId) {
        return memberTemplateMapper.selectMemberTemplates(memberId);
    }

    // 특정 회원의 공개된 템플릿 조회
    @Override
    public List<MemberTemplateDTO> findMemberTemplatePublicAll(Long memberId) {
        return memberTemplateMapper.selectMemberTemplatePublicAll(memberId);
    }

    // TODO : 구독중인 회원의 템플릿 조회
}
