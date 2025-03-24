package com.sic.marktory.comment.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(name="written_date", nullable = false)
    private String writtenDate;

    @Column(name="modify_date")
    private String modifyDate;

    @Column(name="is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name="above_id")
    private Long aboveId;

    @Column(name="member_id")
    private Long memberId;

    @Column(name="post_id")
    private Long postId;

    public void updateContent(String content) {
        this.content = content;
        this.modifyDate = LocalDateTime.now().toString();
    }

    public void softDelete() {
        this.isDeleted = true;
    }
    
}
