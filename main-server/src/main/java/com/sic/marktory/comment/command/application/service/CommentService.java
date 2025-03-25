package com.sic.marktory.comment.command.application.service;

import com.sic.marktory.comment.command.application.dto.CommentCreateRequest;
import com.sic.marktory.comment.command.application.dto.CommentUpdateRequest;

public interface CommentService {

    Long createComment(Long postId, CommentCreateRequest request);

    Long updateComment(Long postId, CommentUpdateRequest request);

    Long deleteComment(Long commentId);

}
