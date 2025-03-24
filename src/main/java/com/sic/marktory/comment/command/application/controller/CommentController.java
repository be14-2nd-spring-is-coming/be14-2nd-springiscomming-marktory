package com.sic.marktory.comment.command.application.controller;

import com.sic.marktory.comment.command.application.dto.CommentCreateRequest;
import com.sic.marktory.comment.command.application.dto.CommentUpdateRequest;
import com.sic.marktory.comment.command.application.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("commandCommentController")
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/postComment/{postId}")
    public ResponseEntity<String> postComment(@PathVariable Long postId,
                                            @RequestBody CommentCreateRequest request) {

        if (request.getAboveId() != null) {
            request.setType(2);
        } else {
            request.setType(1);
        }

        Long id = commentService.createComment(postId, request);

        return ResponseEntity.ok("댓글이 등록되었습니다.");
    }

    @PostMapping("/updateComment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId,
                                              @RequestBody CommentUpdateRequest request) {
        Long id = commentService.updateComment(commentId, request);

        return ResponseEntity.ok("댓글이 수정되었습니다.");
    }

    @PostMapping("/deleteComment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        Long id = commentService.deleteComment(commentId);

        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }

}
