package com.sic.marktory.member.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/* 설명. 이메일 인증을 위한 entity */
@Entity
@Table(name = "email_token")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class EmailToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String token;

    private LocalDateTime expirationTime;

    private boolean isVerified = false;
}
