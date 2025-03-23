package com.sic.marktory.comment.query.mapper;

import com.sic.marktory.comment.query.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentDTO> selectCommentsByPostId(@Param("postId") Long postId);

    List<CommentDTO> selectReplyCommentsByAboveId(@Param("aboveId") Long aboveId);
}
