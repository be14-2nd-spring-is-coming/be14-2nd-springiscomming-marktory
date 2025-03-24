package com.sic.marktory.comment.command.application.service;

import com.sic.marktory.comment.command.application.dto.CommentRequestDTO;
import com.sic.marktory.comment.command.application.dto.CommentResponseDTO;
import com.sic.marktory.comment.command.domain.aggregate.CommentEntity;
import com.sic.marktory.comment.command.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("commandCommentServiceImpl")
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public Long createComment(Long postId, CommentRequestDTO request) {
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
}
