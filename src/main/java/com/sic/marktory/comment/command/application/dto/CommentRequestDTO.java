package com.sic.marktory.comment.command.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentRequestDTO {

    @NotNull
    private String content;

    private Long aboveId;

    private int type;

    private Long memberId;  // 로그인 구현 전 임시


}
