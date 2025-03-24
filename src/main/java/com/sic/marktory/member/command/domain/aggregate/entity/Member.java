package com.sic.marktory.member.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


// 멤버 엔티티 생성
@Entity
@Table(name = "member")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @Column(name = "birthday", nullable = false)
    private String birthday;

    @Column(name = "image")
    private String image;

    @Column(name = "status", nullable = false)
    private String status = "is_active";

    @Column(name = "black_date")
    private String blackDate;

    @Column(name = "assigned_date", nullable = false)
    private String assignedDate;

    @Column(name = "delete_date")
    private String deleteDate;

    @Column(name = "report_count", nullable = false)
    private int reportCount = 0;

    @Column(name = "is_terms", nullable = false)
    private boolean isTerms;

}
