package com.sic.marktory.member.command.domain.repository;

import com.sic.marktory.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* 설명. member command-repository 구현 */
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

    MemberEntity findByNickname(String nickname);
}
