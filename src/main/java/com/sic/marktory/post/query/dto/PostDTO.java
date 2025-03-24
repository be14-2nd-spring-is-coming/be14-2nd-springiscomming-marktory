package com.sic.marktory.post.query.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {
        private int id;
        private String title;
        private String content;
        private String writtenDate;
        private String deleteDate;
        private String visibility;
        private int memberId;
        private int categoryId;
}
