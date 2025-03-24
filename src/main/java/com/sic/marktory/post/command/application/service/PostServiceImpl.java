package com.sic.marktory.post.command.application.service;

import com.sic.marktory.post.command.application.dto.PostCreateRequestDTO;
import com.sic.marktory.post.command.domain.aggregate.PostEntity;
import com.sic.marktory.post.command.domain.aggregate.Visibility;
import com.sic.marktory.post.command.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

@Service("commandServiceImpl")
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public Long createPost(PostCreateRequestDTO request) {
        // Visibility 값이 null이면 기본값 "public" 설정
        String visibilityValue = (request.getVisibility() != null) ? request.getVisibility() : "public";

        // PostEntity 빌드
        PostEntity post = PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writtenDate(Date.from(Instant.now()).toString()) // 혹은 LocalDateTime으로 변환
                .visibility(new Visibility(visibilityValue)) // Visibility Embeddable로 생성
                .build();

        return postRepository.save(post).getId();
    }

}
