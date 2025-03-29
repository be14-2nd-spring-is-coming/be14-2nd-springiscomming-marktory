package com.sic.marktory.member.query.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class MemberPageDTO {
    private String nickname;
    private String image;
    private String assignedDate;
}
