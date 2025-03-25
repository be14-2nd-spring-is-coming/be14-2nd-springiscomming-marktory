package com.sic.marktory.post.command.domain.repository;

import com.sic.marktory.post.command.domain.aggregate.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
