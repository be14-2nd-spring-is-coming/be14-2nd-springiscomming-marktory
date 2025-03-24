package com.sic.marktory.member.command.domain.repository;

import com.sic.marktory.member.command.domain.aggregate.entity.EmailTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/* 설명. 추후에, Redis로 리팩토링 할 레포지토리 클래스 */
public interface EmailRepository extends JpaRepository<EmailTokenEntity, Long> {

    EmailTokenEntity findByToken(String token);

    EmailTokenEntity findByEmail(String email);
}
