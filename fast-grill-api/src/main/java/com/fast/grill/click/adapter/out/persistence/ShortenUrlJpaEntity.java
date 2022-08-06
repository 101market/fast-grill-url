package com.fast.grill.click.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Table(name = "shorten_url")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortenUrlJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    // unique index 추가하기
    private String shortenToken;

    private String originUrl;

    @Enumerated(EnumType.STRING)
    private Status status;

    private ZonedDateTime expiredAt;

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
