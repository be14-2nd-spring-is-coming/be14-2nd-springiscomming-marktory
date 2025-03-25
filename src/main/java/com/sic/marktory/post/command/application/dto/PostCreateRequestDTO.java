package com.sic.marktory.post.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PostCreateRequestDTO {
    private Long id;
    private String title;
    private String content;
    private String written_date;
    private String delete_date;
    private String visibility;
}
