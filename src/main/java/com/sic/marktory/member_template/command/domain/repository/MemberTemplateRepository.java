package com.sic.marktory.member_template.command.domain.repository;

import com.sic.marktory.member_template.command.domain.aggregate.MemberTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTemplateRepository extends JpaRepository<MemberTemplateEntity, Long> {
}
