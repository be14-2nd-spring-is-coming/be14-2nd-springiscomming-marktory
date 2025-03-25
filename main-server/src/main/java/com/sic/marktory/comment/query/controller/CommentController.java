package com.sic.marktory.comment.query.controller;

import com.sic.marktory.comment.query.dto.CommentDTO;
import com.sic.marktory.comment.query.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Comment Query", description = "조회")
@RestController("queryCommentController")
@RequestMapping("api/comment")
@Slf4j
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
            this.commentService = commentService;
    }

    @Operation(
            summary = "게시글의 모든 댓글 조회",
            description = """
        특정 게시글에 달린 모든 댓글을 조회합니다.
        - `postId`를 경로 변수로 받아 해당 게시글의 댓글 목록을 반환합니다.
        - 댓글은 정렬된 형태(예: 최신순, 트리구조 등)로 응답됩니다.
        - 대댓글도 포함된 구조일 수 있습니다 (비즈니스 로직에 따라 다름).
        """
    )
    @GetMapping("/getComments/{postId}")
    public List<CommentDTO> getComments(@PathVariable Long postId) {
        return commentService.findCommentsByPostId(postId);
    }

    // FIXME: 추후 삭제 (주석처리하는 코딩방법은 지양해야함)
//    @GetMapping("/getReplyComments/{aboveId}")
//    public List<CommentDTO> getReplyComments(@PathVariable Long aboveId) {
//        return commentService.findReplyCommentsByAboveId(aboveId);
//    }

}

