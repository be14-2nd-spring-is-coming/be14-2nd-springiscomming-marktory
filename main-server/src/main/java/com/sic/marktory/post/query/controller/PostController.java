package com.sic.marktory.post.query.controller;

import com.sic.marktory.post.query.dto.PostDTO;
import com.sic.marktory.post.query.service.PostService;
import com.sic.marktory.post.query.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 회원 공개 게시글 전체 조회 API
    @GetMapping("/public")
    public ResponseEntity<List<PostDTO>> getPublicPosts() {
        List<PostDTO> posts = postService.findPublicPosts();

        // 204 No Content
        if (posts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // 200 OK
        return ResponseEntity.ok(posts);
    }
}
