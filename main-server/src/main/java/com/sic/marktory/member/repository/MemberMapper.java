package com.sic.marktory.member.repository;

import com.sic.marktory.member.dto.MemberWithRoleDTO;
import org.apache.ibatis.annotations.Mapper;

/* 설명. 인증용 mapper */
@Mapper
public interface MemberMapper {
    MemberWithRoleDTO selectMemberWithRoleByEmail(String email);
}
