package com.fastgrill.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Getter
@RequiredArgsConstructor
@Builder
public class ClickUrl implements Serializable {
    private static final long serialVersionUID = 1L;

    private String originUrl;

    private String shortenToken;

    private boolean enable;

    private ClickThresholdContract thresholdContract;

    public ClickUrl(String originUrl, String shortenToken, boolean enable, ClickThresholdContract thresholdContract) {
        this.originUrl = originUrl;
        this.shortenToken = shortenToken;
        this.enable = enable;
        this.thresholdContract = thresholdContract;
    }

    public boolean isExpired() {
        var expiredAt = thresholdContract.getExpiredAt();
        return expiredAt.isBefore(Instant.now());
    }

    public boolean isExceedThresholdCount(long accumulatedRequestCount) {
        Long thresholdRequestCount = thresholdContract.getThresholdRequestCount();
        return thresholdRequestCount < accumulatedRequestCount;
    }
}
