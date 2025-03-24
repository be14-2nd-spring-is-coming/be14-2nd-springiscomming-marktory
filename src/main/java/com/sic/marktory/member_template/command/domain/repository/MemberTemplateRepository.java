package com.sic.marktory.member_template.command.domain.repository;

import com.sic.marktory.member_template.command.application.entity.MemberTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTemplateRepository extends JpaRepository<MemberTemplateEntity, Long> {

}
