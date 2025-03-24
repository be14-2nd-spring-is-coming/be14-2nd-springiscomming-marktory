package com.sic.marktory.comment.command.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDTO {

    @NotNull
    private Long postId;

    private int type;
    private Long aboveId;

    @NotNull
    private String memberId;

    @NotNull(message="댓글 내용을 입력해 주세요.")
    private String content;
}
