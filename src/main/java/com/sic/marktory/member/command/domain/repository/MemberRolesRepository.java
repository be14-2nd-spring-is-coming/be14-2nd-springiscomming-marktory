package com.sic.marktory.member.command.domain.repository;

import com.sic.marktory.member.command.domain.aggregate.entity.MemberRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRolesRepository extends JpaRepository<MemberRolesEntity, Integer> {
}
