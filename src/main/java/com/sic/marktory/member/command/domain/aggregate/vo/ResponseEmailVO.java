package com.sic.marktory.member.command.domain.aggregate.vo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode // setter 못쓰는 vo를 위해 사용
public class ResponseEmailVO {
    /* 설명. 응답값을 위해 token을 부여 */
    private String email;
    private String token;
    private String message;
}
