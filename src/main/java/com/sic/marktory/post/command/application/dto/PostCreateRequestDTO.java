package com.sic.marktory.post.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRequestDTO {
    private Long id;
    private String title;
    private String content;
    private String written_date;
    private String delete_date;
    private String visibility;
}
