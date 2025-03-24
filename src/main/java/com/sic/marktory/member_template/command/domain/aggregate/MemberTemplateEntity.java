package com.sic.marktory.member_template.command.domain.aggregate;

import com.sic.marktory.common.DateTimeUtil;
import com.sic.marktory.member_template.command.application.vo.Visibility;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// TODO: report_type command도 만들어야 hibernate가 정상적으로 해당 테이블을 Drop
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
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

    @AttributeOverride(name = "value", column = @Column(name = "visibility", nullable = false))
    private Visibility visibility;

    @Column(name = "is_copy" , nullable = false)
    private Character isCopy;

    @Column(name = "repository_id")
    private Long repositoryId;

    public void update(String title, String content, Visibility visibility, String writtenDate) {
        this.title = title;
        this.content = content;
        this.visibility = visibility;
        this.writtenDate = writtenDate;
    }

    public void delete() {
        this.deleteDate = DateTimeUtil.nowFormatted();
    }

}
