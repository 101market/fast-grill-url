package com.fastgrill.core.shortenurl.adapter.out.persistence;

import com.fastgrill.core.utils.Base62;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "shorten_url")
@Getter
@Builder
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

    public static ShortenUrlJpaEntity create(String originUrl, Instant expiredAt, Long thresholdRequestCount){
        return ShortenUrlJpaEntity.builder()
                .originUrl(originUrl)
                .expiredAt(expiredAt)
                .thresholdRequestCount(thresholdRequestCount)
                .status(Status.DISABLE)
                .build();
    }

    @PostPersist
    public void updateShortenToken(){
        this.shortenToken = Base62.encodeToLong(id);
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }

    public boolean isEnable(){
        return status == Status.ENABLE;
    }

    public void update(Instant expiredAt, Long thresholdRequestCount) {
        this.expiredAt = expiredAt;
        this.thresholdRequestCount = thresholdRequestCount;
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }
}
