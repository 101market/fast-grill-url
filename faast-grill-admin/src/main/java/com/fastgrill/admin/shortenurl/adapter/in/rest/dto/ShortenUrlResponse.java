package com.fastgrill.admin.shortenurl.adapter.in.rest.dto;

import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ShortenUrlResponse {
    private Long id;
    private String shortenUrl;
    private String originUrl;
    private Instant expiredAt;
    private Long thresholdRequestCount;

    public static ShortenUrlResponse fromShortenUrl(ShortenUrl shortenToken) {
        return ShortenUrlResponse.builder()
                .id(shortenToken.getId())
                .shortenUrl(shortenToken.getShortenUrl())
                .originUrl(shortenToken.getOriginUrl())
                .expiredAt(shortenToken.getExpiredAt())
                .thresholdRequestCount(shortenToken.getThresholdRequestCount())
                .build();
    }
}
