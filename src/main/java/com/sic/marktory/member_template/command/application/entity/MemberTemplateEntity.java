package com.sic.marktory.member_template.command.application.entity;

import com.sic.marktory.member_template.command.application.vo.Visibility;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "member_template")
public class MemberTemplateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name="written_date" , nullable = false)
    private String writtenDate;

    @Column(name = "delete_date")
    private String deleteDate;

    @Column(name = "usage_count" , nullable = false)
    private Integer usageCount;

    @Embedded
    @Column(name = "visibility", nullable = false)
    private Visibility visibility;

    @Column(name = "is_copy" , nullable = false)
    private Character isCopy;

    @Column(name = "repository_id")
    private Long repositoryId;
}
