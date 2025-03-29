package com.sic.marktory.report.query.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportDTO {

    private Long id;
    private String content;
    private Boolean status;
    private String date;
    private String type;
    private Long memberId;
    private Long postId;
    private Long commentId;
    private Long templateId;
    private String name;
    private Long reportCount;

}
