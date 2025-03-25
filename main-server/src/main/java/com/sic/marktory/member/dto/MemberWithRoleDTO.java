package com.sic.marktory.member.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberWithRoleDTO {
    private int id;
    private String email;
    private String password;
    private String role; // 조인된 권한 (ex. ROLE_ADMIN)
}