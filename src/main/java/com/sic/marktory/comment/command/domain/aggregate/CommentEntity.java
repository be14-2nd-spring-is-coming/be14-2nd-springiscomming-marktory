package com.sic.marktory.comment.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(name="written_date", nullable = false)
    private LocalDateTime writtenDate;

    @Column(name="modify_date")
    private LocalDateTime modifyDate;

    @Column(name="is_deleted", nullable = false)
    @Builder.Default
    private Boolean isDeleted = false;

    @Column(nullable = false)
    private int type;

    @Column(name="above_id")
    private Long aboveId;

    @Column(name="member_id")
    private Long memberId;

    @Column(name="post_id")
    private Long postId;

    public void updateContent(String content) {
        this.content = content;
        this.modifyDate = LocalDateTime.now().withNano(0);
    }

    public void softDelete() {
        this.isDeleted = true;
    }

}
