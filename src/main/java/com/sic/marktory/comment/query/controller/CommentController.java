package com.sic.marktory.comment.query.controller;

import com.sic.marktory.comment.query.dto.CommentDTO;
import com.sic.marktory.comment.query.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
            this.commentService = commentService;
    }

    @GetMapping("/getComments/{postId}")
    public List<CommentDTO> getComments(@PathVariable Long postId) {
        return commentService.findCommentsByPostId(postId);
    }

    @GetMapping("/getReplyComments/{aboveId}")
    public List<CommentDTO> getReplyComments(@PathVariable Long aboveId) {
        return commentService.findReplyCommentsByAboveId(aboveId);
    }

}

