package com.sic.marktory.member.query.mapper;

import com.sic.marktory.member.query.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    MemberDTO selectByEmail(String email);

    MemberWithRoleDTO selectMemberWithRoleByEmail(String email);

    MemberPageDTO selectById(Long memberId);

    List<MemberAndPostDTO> selectByIdAndPost(Long memberId);

    List<MemberAndCommentDTO> selectByIdAndComment(Long memberId);

    List<MemberAndTemplateDTO> selectByIdAndTemplate(Long memberId);
}
