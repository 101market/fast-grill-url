package com.fastgrill.admin.shortenurl.adapter.in.web.dto;

import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ModifyShortenUrlResponse {
    private Long id;
    private String shortenUrl;
    private String originUrl;
    private Instant expiredAt;
    private Long thresholdRequestCount;

    public static ModifyShortenUrlResponse fromShortenUrl(ShortenUrl shortenToken) {
        return ModifyShortenUrlResponse.builder()
                .id(shortenToken.getId())
                .shortenUrl(shortenToken.getShortenUrl())
                .originUrl(shortenToken.getOriginUrl())
                .expiredAt(shortenToken.getExpiredAt())
                .thresholdRequestCount(shortenToken.getThresholdRequestCount())
                .build();
    }
}
