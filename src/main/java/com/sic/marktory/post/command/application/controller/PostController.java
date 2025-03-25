package com.sic.marktory.post.command.application.controller;

import com.sic.marktory.post.command.application.dto.PostCreateRequestDTO;
import com.sic.marktory.post.command.application.dto.PostUpdateRequestDTO;
import com.sic.marktory.post.command.application.service.PostService;
import com.sic.marktory.post.command.application.service.PostServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("postCommandController")
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostServiceImpl postService;

    // 1. 게시글 작성
    @PostMapping("/creatPost")
    public ResponseEntity<Long> postCreatePost(@RequestBody PostCreateRequestDTO request) {
        Long id = postService.createPost(request);
        return ResponseEntity.ok(id);  // 게시글 작성 완료시 알림
    }

    // 2. 게시글 수정
    @PutMapping("/updatePost/{id}")
    public ResponseEntity<String> updatePost(
            @PathVariable Long id,
            @RequestBody PostUpdateRequestDTO request) {

        try {
            postService.updatePost(id, request);  // 서비스 계층 호출
            return ResponseEntity.ok("게시글 업데이트 성공");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());  // 게시글을 찾지 못한 경우
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());  // 잘못된 요청인 경우
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류 발생");
        }
    }

    // 3. 게시글 삭제
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Long> putDeletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}



