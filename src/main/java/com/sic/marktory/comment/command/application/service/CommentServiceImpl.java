package com.sic.marktory.comment.command.application.service;

import com.sic.marktory.comment.command.application.dto.CommentCreateRequest;
import com.sic.marktory.comment.command.application.dto.CommentUpdateRequest;
import com.sic.marktory.comment.command.domain.aggregate.CommentEntity;
import com.sic.marktory.comment.command.domain.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service("commandCommentServiceImpl")
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Long createComment(Long postId, CommentCreateRequest request) {
        CommentEntity comment = CommentEntity.builder()
                .content(request.getContent())
                .writtenDate(LocalDateTime.now().withNano(0))
                .aboveId(request.getAboveId())
                .type(request.getType())
                .memberId(request.getMemberId())
                .postId(postId)
                .isDeleted(false)
                .build();
        return commentRepository.save(comment).getId();
    }

    @Override
    @Transactional
    public Long updateComment(Long commentId, CommentUpdateRequest request) {
        CommentEntity comment = commentRepository.findById(commentId).orElseThrow(EntityNotFoundException::new);

        comment.updateContent(request.getContent());

        return comment.getId();
    }

    @Override
    @Transactional
    public Long deleteComment(Long commentId) {
        CommentEntity comment = commentRepository.findById(commentId).orElseThrow(EntityNotFoundException::new);

        comment.softDelete();

        return comment.getId();
    }


}
