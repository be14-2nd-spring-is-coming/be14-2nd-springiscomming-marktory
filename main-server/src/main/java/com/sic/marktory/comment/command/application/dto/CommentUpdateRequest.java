package com.sic.marktory.comment.command.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentUpdateRequest {

    @NotNull
    private String content;

}
