package com.sic.marktory.subscribe.query.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 조회 데이터 DTO
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class MemberDTO {
    private Long id;
    private String email;
    private String nickname;
    private String image;

    @JsonIgnore
    private String name;

    @JsonIgnore
    private String birthday;

    @JsonIgnore
    private String blackDate;

    @JsonIgnore
    private String assignedDate;

    @JsonIgnore
    private String deleteDate;

    @JsonIgnore
    private int reportCount;

    @JsonIgnore
    private Boolean isTerms;
}
