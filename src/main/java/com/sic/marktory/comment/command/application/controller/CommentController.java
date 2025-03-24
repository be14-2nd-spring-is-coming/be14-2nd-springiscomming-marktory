package com.sic.marktory.comment.command.application.controller;

import com.sic.marktory.comment.command.application.dto.CommentCreateRequest;
import com.sic.marktory.comment.command.application.dto.CommentUpdateRequest;
import com.sic.marktory.comment.command.application.service.CommentService;
import com.sic.marktory.comment.common.exception.CommentAlreadyDeletedException;
import com.sic.marktory.comment.common.exception.CommentNotFoundException;
import com.sic.marktory.comment.common.exception.EmptyCommentContentException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        try {
            if (request.getAboveId() != null) {
                request.setType(2);
            } else {
                request.setType(1);
            }

            Long id = commentService.createComment(postId, request);

            return ResponseEntity.status(HttpStatus.CREATED).body("댓글이 등록되었습니다.");
        } catch (EmptyCommentContentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/updateComment/{commentId}")
    public ResponseEntity<String> updateComment(@PathVariable Long commentId,
                                              @RequestBody CommentUpdateRequest request) {

        try {
            Long id = commentService.updateComment(commentId, request);

            return ResponseEntity.status(HttpStatus.OK).body("댓글이 수정되었습니다.");
        } catch (EmptyCommentContentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (CommentAlreadyDeletedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (CommentNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/deleteComment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {

        try {
            Long id = commentService.deleteComment(commentId);

            return ResponseEntity.status(HttpStatus.OK).body("댓글이 삭제되었습니다.");
        } catch (CommentAlreadyDeletedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}
