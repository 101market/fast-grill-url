package com.fastgrill.core.shortenurl.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "shorten_url")
@Data
@EqualsAndHashCode(callSuper = true) // TODO: 인텔리제이 주도 개발로 썼지만, 뭔지 알고 쓰기
@AllArgsConstructor
@NoArgsConstructor
public class ShortenUrlJpaEntity extends AbstractJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    // unique index 추가하기
    private String shortenToken;

    private String originUrl;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Instant expiredAt;

    private Long thresholdRequestCount;

    public boolean isEnable(){
        return status == Status.ENABLE;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }
}
