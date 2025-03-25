package com.sic.marktory.post.command.application.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class PostUpdateRequestDTO {

        private String title;
        private String content;
        private String visibility;


}
