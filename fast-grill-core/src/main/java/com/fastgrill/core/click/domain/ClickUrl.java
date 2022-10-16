package com.fastgrill.core.click.domain;

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

    private boolean enable;

    private ClickThresholdContract thresholdContract;

    public ClickUrl(String originUrl, boolean enable, ClickThresholdContract thresholdContract) {
        this.originUrl = originUrl;
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
