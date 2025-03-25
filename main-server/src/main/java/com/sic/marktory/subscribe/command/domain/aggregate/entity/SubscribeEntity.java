package com.sic.marktory.subscribe.command.domain.aggregate.entity;

import com.sic.marktory.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(
        name = "subscribe",
        uniqueConstraints = @UniqueConstraint(columnNames = {"subscriber_id", "subscribed_id"})
)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubscribeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 구독자 (이 사람이 다른 사람을 구독함)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriber_id", nullable = false)
    private MemberEntity subscriber;

    // 구독 대상 (이 사람이 구독됨)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscribed_id", nullable = false)
    private MemberEntity subscribed;

    @Column(name = "is_notification", nullable = false)
    private char isNotification; // 'Y' or 'N'

    public SubscribeEntity(MemberEntity subscriber, MemberEntity subscribed, char isNotification) {
        this.subscriber = subscriber;
        this.subscribed = subscribed;
        this.isNotification = isNotification;
    }

    public void updateNotification(boolean enable)  {
        this.isNotification = enable ? 'Y' : 'N';
    }
}
