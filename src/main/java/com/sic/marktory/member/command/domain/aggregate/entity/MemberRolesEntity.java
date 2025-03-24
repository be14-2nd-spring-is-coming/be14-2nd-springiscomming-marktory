package com.sic.marktory.member.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

/* 설명. 멤버가 삽입되면 자동으로 권한 분리되는 중간테이블 엔티티 */
@Entity
@Table(name = "member_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberRolesEntity {
    @Id
    @Column(name = "member_id")
    private int memberId;
    @Column(name = "authority_id")
    private int roleId;

}
