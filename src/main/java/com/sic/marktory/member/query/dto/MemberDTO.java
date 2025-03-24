package com.sic.marktory.member.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class MembetDTO {
    private int id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String birthday;
    private String image;
    private String status;
    private String blackDate;
    private String assignedDate;
    private int reportCount;
    private Boolean isTerms;
}
