package com.sic.marktory.member.query.dto;

import lombok.*;

/* 설명. 멤버를 가지고, 조인된 회원 권한이름을 가져올 때 사용하는 DTO */
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class MemberWithRoleDTO {
    private int id;
    private String email;
    private String password;
    private String role; // 조인된 권한 (ex. ROLE_ADMIN)
}
