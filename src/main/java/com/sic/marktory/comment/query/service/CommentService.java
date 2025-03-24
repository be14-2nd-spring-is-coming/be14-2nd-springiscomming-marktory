package com.sic.marktory.comment.query.service;

import com.sic.marktory.comment.query.dto.CommentDTO;
import com.sic.marktory.comment.query.mapper.CommentMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("queryCommentService")
@Slf4j
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public List<CommentDTO> findCommentsByPostId(Long postId) {
        return commentMapper.selectCommentsByPostId(postId);
    }

    public List<CommentDTO> findReplyCommentsByAboveId(Long aboveId) {
        return commentMapper.selectReplyCommentsByAboveId(aboveId);
    }

}
