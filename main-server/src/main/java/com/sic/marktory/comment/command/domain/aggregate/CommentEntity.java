package com.sic.marktory.comment.command.domain.aggregate;

import com.sic.marktory.common.DateTimeUtil;
import jakarta.persistence.*;
import lombok.*;

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
    private String writtenDate;

    @Column(name="modify_date")
    private String modifyDate;

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
        this.modifyDate = DateTimeUtil.nowFormatted();
    }

    public void softDelete() {
        this.isDeleted = true;
    }

}
