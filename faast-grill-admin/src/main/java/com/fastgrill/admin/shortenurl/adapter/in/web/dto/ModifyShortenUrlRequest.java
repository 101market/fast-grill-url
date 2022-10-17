package com.fastgrill.admin.shortenurl.adapter.in.web.dto;

import com.fastgrill.admin.shortenurl.application.port.in.ModifyShortenUrlCommand;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ModifyShortenUrlRequest {
    private String originUrl;
    private Instant expiredAt;
    private Long thresholdRequestCount;

    public ModifyShortenUrlCommand toCommandWith(Long shortenUrlId) {
        return ModifyShortenUrlCommand.builder()
                .id(shortenUrlId)
                .originUrl(originUrl)
                .expiredAt(expiredAt)
                .thresholdRequestCount(thresholdRequestCount)
                .build();
    }
}
