package com.sic.marktory.post.command.application.dto;

import com.sic.marktory.post.command.domain.aggregate.vo.Visibility;
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
