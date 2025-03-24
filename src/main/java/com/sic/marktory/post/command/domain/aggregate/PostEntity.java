package com.sic.marktory.post.command.domain.aggregate;

import com.sic.marktory.category.domain.CategoryEntity;
import com.sic.marktory.member.command.domain.aggregate.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "written_date", nullable = false)
    private String writtenDate;  // 변경 가능: LocalDateTime으로 변환 고려

    @Column(name = "delete_date")
    private String deleteDate;   // 변경 가능: LocalDateTime으로 변환 고려

    @Embedded
    @Column(name = "visibility", nullable = false)
    private Visibility visibility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_post_member"))
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_post_category"))
    private CategoryEntity category;


}
