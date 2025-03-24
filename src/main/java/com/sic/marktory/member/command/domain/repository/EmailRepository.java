package com.sic.marktory.member.command.domain.repository;

import com.sic.marktory.member.command.domain.aggregate.entity.EmailToken;
import com.sic.marktory.member.command.domain.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/* 설명. 추후에, Redis로 리팩토링 할 레포지토리 클래스 */
public interface EmailRepository extends JpaRepository<EmailToken, Long> {

    EmailToken findByToken(String token);

    EmailToken findByEmail(String email);
}
