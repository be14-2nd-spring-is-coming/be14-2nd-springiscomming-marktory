package com.sic.marktory.comment.command.domain.repository;

import com.sic.marktory.comment.command.domain.aggregate.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
