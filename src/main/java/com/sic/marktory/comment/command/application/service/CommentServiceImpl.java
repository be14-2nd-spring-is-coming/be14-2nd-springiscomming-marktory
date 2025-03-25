package com.sic.marktory.comment.command.application.service;

import com.sic.marktory.comment.command.application.dto.CommentCreateRequest;
import com.sic.marktory.comment.command.application.dto.CommentUpdateRequest;
import com.sic.marktory.comment.command.domain.aggregate.CommentEntity;
import com.sic.marktory.comment.command.domain.repository.CommentRepository;
import com.sic.marktory.comment.common.exception.CommentAlreadyDeletedException;
import com.sic.marktory.comment.common.exception.CommentNotFoundException;
import com.sic.marktory.comment.common.exception.EmptyCommentContentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service("commandCommentServiceImpl")
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Long createComment(Long postId, CommentCreateRequest request) {
        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            throw new EmptyCommentContentException("댓글 내용이 비어 있습니다.");
        }

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
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("해당 댓글을 찾을 수 없습니다."));

        if (comment.getIsDeleted()) {
            throw new CommentAlreadyDeletedException("이미 삭제된 댓글입니다.");
        }

        if (request.getContent() == null || request.getContent().trim().isEmpty()) {
            throw new EmptyCommentContentException("댓글 내용이 비어 있습니다.");
        }

        comment.updateContent(request.getContent());

        return comment.getId();
    }

    @Override
    @Transactional
    public Long deleteComment(Long commentId) {
        CommentEntity comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException("해당 댓글을 찾을 수 없습니다."));

        if (comment.getIsDeleted()) {
            throw new CommentAlreadyDeletedException("이미 삭제된 댓글입니다.");
        }

        comment.softDelete();

        return comment.getId();
    }


}
