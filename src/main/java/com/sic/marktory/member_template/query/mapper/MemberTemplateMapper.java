package com.sic.marktory.member_template.query.mapper;

import com.sic.marktory.member_template.query.dto.MemberTemplateDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberTemplateMapper {
    List<MemberTemplateDTO> selectMemberTemplatePublicAll();
}
