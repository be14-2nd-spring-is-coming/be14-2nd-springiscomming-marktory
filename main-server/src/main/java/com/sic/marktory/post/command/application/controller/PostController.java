package com.sic.marktory.post.command.application.controller;

import com.sic.marktory.post.command.application.dto.PostCreateRequestDTO;
import com.sic.marktory.post.command.application.dto.PostUpdateRequestDTO;
import com.sic.marktory.post.command.application.service.PostService;
import com.sic.marktory.post.command.application.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Post Command", description = "작성, 수정, 삭제")
@RestController("postCommandController")
@RequestMapping("/api/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostServiceImpl postService;

    // 1. 게시글 작성
    @Operation(
            summary = "게시글 작성",
            description = """
        새로운 게시글을 작성합니다.
        - 요청 본문에 제목, 내용, 공개 범위 등 게시글 정보를 담아 전달합니다.
        - 성공 시 생성된 게시글 ID를 반환합니다.
        """
    )
    @PostMapping("/creatPost")
    public ResponseEntity<Long> postCreatePost(@RequestBody PostCreateRequestDTO request) {
        Long id = postService.createPost(request);
        return ResponseEntity.ok(id);  // 게시글 작성 완료시 알림
    }

    // 2. 게시글 수정
    @Operation(
            summary = "게시글 수정",
            description = """
        기존 게시글의 내용을 수정합니다.
        - 게시글 ID는 경로 변수로 전달되며, 수정할 데이터는 요청 본문으로 전달합니다.
        - 존재하지 않는 게시글일 경우 404 NOT FOUND 응답이 반환됩니다.
        - 잘못된 요청이면 400 BAD REQUEST, 서버 오류 시 500 응답이 반환됩니다.
        """
    )
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
    @Operation(
            summary = "게시글 삭제",
            description = """
        지정한 ID의 게시글을 삭제 처리합니다 (soft delete).
        - 게시글 ID는 경로 변수로 전달됩니다.
        - 성공 시 본문 없는 200 OK 응답을 반환합니다.
        """
    )
    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Long> putDeletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok().build();
    }
}



