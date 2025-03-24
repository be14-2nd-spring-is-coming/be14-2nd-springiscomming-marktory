package com.sic.marktory.comment.command.application.service;

import com.sic.marktory.comment.command.application.dto.CommentRequestDTO;

public interface CommentService {

    Long createComment(Long postId, CommentRequestDTO request);

}
