package com.sic.marktory.report.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
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

}
