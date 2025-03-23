package com.sic.marktory.comment.query.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentDTO {

    private Long id;
    private int type;
    private Long aboveId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer level;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String sortPath;

    private String content;
    private String writtenDate;
    private String modifyDate;
    private String nickname;
    private int likesCount;

    public void setLevel(int level) {
        this.level = (level == 0) ? null : level;
    }


}
