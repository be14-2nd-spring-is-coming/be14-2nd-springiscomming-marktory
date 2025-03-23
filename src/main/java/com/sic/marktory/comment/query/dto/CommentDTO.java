package com.sic.marktory.comment.query.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {
    private Long id;
    private String content;
    private String writtenDate;
    private String modifyDate;
    private String nickname;
    private int replyCount;
    private int likesCount;
}
