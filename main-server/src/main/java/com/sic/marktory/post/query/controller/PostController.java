package com.sic.marktory.post.query.controller;

import com.sic.marktory.post.query.dto.PostDTO;
import com.sic.marktory.post.query.service.PostService;
import com.sic.marktory.post.query.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Tag(name = "Post Query", description = "게시글 조회")
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 회원 공개 게시글 전체 조회 API
    @Operation(
            summary = "회원 공개 게시글 전체 조회",
            description = """
        공개 설정된 모든 게시글을 조회합니다.
        - 로그인 여부와 관계없이 접근 가능한 API입니다.
        - 게시글이 하나도 없을 경우 204 No Content 응답을 반환합니다.
        - 게시글이 존재하면 200 OK와 함께 게시글 목록이 반환됩니다.
        """
    )
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
