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

    @Override
    public List<MemberTemplateDTO> findMemberTemplatePublicAll() {
        return memberTemplateMapper.selectMemberTemplatePublicAll();
    }
}
