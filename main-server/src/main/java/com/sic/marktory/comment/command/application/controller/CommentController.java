package com.sic.marktory.comment.command.application.controller;

import com.sic.marktory.comment.command.application.dto.CommentCreateRequest;
import com.sic.marktory.comment.command.application.dto.CommentUpdateRequest;
import com.sic.marktory.comment.command.application.service.CommentService;
import com.sic.marktory.comment.common.exception.CommentAlreadyDeletedException;
import com.sic.marktory.comment.common.exception.CommentNotFoundException;
import com.sic.marktory.comment.common.exception.EmptyCommentContentException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Comment Command", description = "수정, 작성, 삭제")
@RestController("commandCommentController")
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    @Operation(
            summary = "게시글에 댓글 작성",
            description = """
        특정 게시글에 댓글을 작성합니다.
        - 대댓글을 작성하려면 `aboveId` 값을 포함하세요.
        - 내용이 비어 있으면 409 CONFLICT 응답이 반환됩니다.
        - 정상적으로 작성되면 201 CREATED 응답과 함께 확인 메시지를 반환합니다.
        """
    )
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

    @Operation(
            summary = "댓글 수정",
            description = """
        특정 댓글의 내용을 수정합니다.
        - 수정 대상 댓글 ID를 path variable로 전달합니다.
        - 내용이 비어 있으면 400 BAD REQUEST,
          이미 삭제된 댓글이면 409 CONFLICT,
          댓글이 존재하지 않으면 404 NOT FOUND 응답이 반환됩니다.
        - 성공 시 200 OK 응답과 확인 메시지를 반환합니다.
        """
    )
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

    @Operation(
            summary = "댓글 삭제",
            description = """
        댓글을 삭제 처리합니다 (soft delete).
        - 삭제 대상 댓글 ID를 path variable로 전달합니다.
        - 이미 삭제된 댓글에 대해 삭제 요청 시 409 CONFLICT 응답이 반환됩니다.
        - 성공 시 200 OK 응답과 함께 삭제 완료 메시지를 반환합니다.
        """
    )
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
