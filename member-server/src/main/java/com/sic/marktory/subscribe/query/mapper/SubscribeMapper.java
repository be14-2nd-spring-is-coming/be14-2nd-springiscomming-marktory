package com.sic.marktory.subscribe.query.mapper;

import com.sic.marktory.subscribe.query.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// MyBatics SQL 실행 매퍼
@Mapper
public interface SubscribeMapper {

    // 내가 구독한 회원들 조회 (memberId가 구독한 목록)
    // 닉네임, 이름, 프로필 사진 등의 조회는 mybatis
    // 간단한 조회 기능만 구현
    List<MemberDTO> selectSubscribedMembers(@Param("memberId") Long memberId);

    // 나를 구독한 회원들 조회 (memberId를 구독하는 목록)
    List<MemberDTO> selectSubscriberMembers(@Param("memberId") Long memberId);
}
