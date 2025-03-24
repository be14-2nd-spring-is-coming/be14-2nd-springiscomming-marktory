package com.sic.marktory.comment.command.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentResponseDTO {

    private Long id;

    private Long postId;

    private int type;

    private Long aboveId;

    @NotNull
    private Long memberId;

    private String writtenDate;

    private String modifyDate;

    @Builder.Default
    private Boolean isDeleted = false;

    @NotNull(message="댓글 내용을 입력해 주세요.")
    private String content;
}
