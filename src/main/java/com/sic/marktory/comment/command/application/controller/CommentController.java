package com.sic.marktory.comment.command.application.controller;

import com.sic.marktory.comment.command.application.dto.CommentRequestDTO;
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
    public ResponseEntity<Long> postComment(@PathVariable Long postId,
                                            @RequestBody CommentRequestDTO request) {

        if (request.getAboveId() != null) {
            request.setType(2);
        } else {
            request.setType(1);
        }

        Long id = commentService.createComment(postId, request);

        return ResponseEntity.ok(id);
    }

}
