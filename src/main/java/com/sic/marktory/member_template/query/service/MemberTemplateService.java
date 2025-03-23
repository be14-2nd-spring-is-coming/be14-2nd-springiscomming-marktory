package com.sic.marktory.member_template.query.service;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import com.sic.marktory.member_template.query.mapper.MemberTemplateMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberTemplateService {
    public List<MemberTemplateDTO> findMemberTemplatePublicAll();
}
