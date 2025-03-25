package com.sic.marktory.member.query.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorityMapper {
    List<String> selectAllRoles();
}
