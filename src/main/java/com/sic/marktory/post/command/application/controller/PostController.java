package com.sic.marktory.post.command.application.controller;

import com.sic.marktory.post.command.application.dto.PostCreateRequestDTO;
import com.sic.marktory.post.command.application.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("postCommandController")
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostServiceImpl postService;

        @PostMapping()
        public ResponseEntity<Long> postCreatePost(@RequestBody PostCreateRequestDTO request) {
            Long id = postService.createPost(request);
            return ResponseEntity.ok(id);
        }

}



