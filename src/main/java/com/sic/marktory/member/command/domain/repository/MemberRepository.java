package com.sic.marktory.member.command.domain.repository;

import com.sic.marktory.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/* 설명. member command-repository 구현 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByNickname(String nickname);
}
