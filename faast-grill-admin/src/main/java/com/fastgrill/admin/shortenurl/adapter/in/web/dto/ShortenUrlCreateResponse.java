package com.fastgrill.admin.shortenurl.adapter.in.web.dto;

import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;

@Getter
@Builder
public class ShortenUrlCreateResponse {
    private Long id;
    private String shortenUrl;
    private String originUrl;
    private Instant expiredAt;
    private Long thresholdRequestCount;

    public static ShortenUrlCreateResponse fromShortenUrl(ShortenUrl shortenToken) {
        return ShortenUrlCreateResponse.builder()
                .id(shortenToken.getId())
                .shortenUrl(shortenToken.getShortenUrl())
                .originUrl(shortenToken.getOriginUrl())
                .expiredAt(shortenToken.getExpiredAt())
                .thresholdRequestCount(shortenToken.getThresholdRequestCount())
                .build();
    }
}
