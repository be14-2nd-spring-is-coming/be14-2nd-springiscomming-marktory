package com.sic.marktory.post.command.domain.aggregate.entity;

import com.sic.marktory.category.domain.CategoryEntity;
import com.sic.marktory.member.entity.MemberEntity;
import com.sic.marktory.member_template.command.application.vo.Visibility;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

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

    @AttributeOverride(name = "value", column = @Column(name = "visibility", nullable = false) )
    private Visibility visibility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_post_member"))
    private MemberEntity member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_post_category"))
    private CategoryEntity category;


    public void postupdate(String title, String content, Visibility visibility, String writtenDate) {
        this.title = title;
        this.content = content;
        this.writtenDate = writtenDate;
        this.visibility = visibility;

    }

    public void postdelete(String deleteDate) {
        this.deleteDate = deleteDate;
    }
}
