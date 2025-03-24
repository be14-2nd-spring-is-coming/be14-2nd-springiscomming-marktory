package com.sic.marktory.post.command.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String written_date;
    private String delete_date;
    private String visibility;
    private int member_id;
    private int category_id;

}
