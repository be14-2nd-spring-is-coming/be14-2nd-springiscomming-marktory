package com.sic.marktory.member_template.query.mapper;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface MemberTemplateMapper {

    // 특정 회원의 템플릿 조회
    List<MemberTemplateDTO> selectMemberTemplatePublicAll(@Param("memberId") Long memberId);

    // 전체 회원의 템플릿 조회
    List<MemberTemplateDTO> selectMemberTemplates(@Param("memberId") Long memberId);
}
