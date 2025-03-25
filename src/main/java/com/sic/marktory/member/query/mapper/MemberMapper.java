package com.sic.marktory.member.query.mapper;

import com.sic.marktory.member.query.dto.MemberDTO;
import com.sic.marktory.member.query.dto.MemberWithRoleDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    MemberDTO selectByEmail(String email);

    MemberWithRoleDTO selectMemberWithRoleByEmail(String email);
}
