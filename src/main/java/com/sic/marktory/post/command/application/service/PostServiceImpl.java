package com.sic.marktory.post.command.application.service;

import com.sic.marktory.common.DateTimeUtil;
import com.sic.marktory.member_template.command.application.vo.Visibility;
import com.sic.marktory.post.command.application.dto.PostCreateRequestDTO;
import com.sic.marktory.post.command.application.dto.PostUpdateRequestDTO;
import com.sic.marktory.post.command.domain.aggregate.entity.PostEntity;
import com.sic.marktory.post.command.domain.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commandPostServiceImpl")
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    // 1. 게시물 작성
    @Override
    @Transactional
    public Long createPost(PostCreateRequestDTO request) {
        // Visibility 값이 null이면 기본값 "public" 설정
        String visibility = (request.getVisibility() != null) ? request.getVisibility() : "public";

        // PostEntity 빌드
        PostEntity post = PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .writtenDate(DateTimeUtil.nowFormatted())
                .visibility(new Visibility(request.getVisibility())).build();// Visibility Embeddable로 생성

        return postRepository.save(post).getId();
    }

    // 게시글 삭제
    @Override
    @Transactional
    public void deletePost(Long id) {
        PostEntity delete = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시물을 찾을 수 없습니다."));
        // 게시글 삭제
        delete.postdelete(
                DateTimeUtil.nowFormatted()
        );
    }

    // 게시물 수정
    @Transactional
    @Override
    public void updatePost(Long id, PostUpdateRequestDTO request) {
        try {
            // 게시글을 찾지 못한 경우 예외 발생
            PostEntity post = postRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
            // 게시글 업데이트
            post.postupdate(
                    request.getTitle(),
                    request.getContent(),
                    new Visibility(request.getVisibility()),
                    DateTimeUtil.nowFormatted()
            );
            // 변경된 엔티티 저장
            postRepository.save(post);
        } catch (EntityNotFoundException e) {
            // 게시글을 찾지 못한 경우
            throw new EntityNotFoundException("게시글을 찾을 수 없습니다.");  // 다시 던지거나 로그를 추가할 수 있습니다.
        } catch (IllegalArgumentException e) {
            // 잘못된 요청인 경우 (예: 요청된 데이터가 유효하지 않음)
            throw new IllegalArgumentException("잘못된 입력이 포함되어 있습니다.");
        } catch (Exception e) {
            // 기타 예기치 않은 예외 처리
            throw new RuntimeException("게시글 업데이트 중 오류가 발생했습니다.", e);
        }
    }



}
