package com.fast.grill.click.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@RequiredArgsConstructor
@Builder
public class ClickUrl {
    private String originUrl;

    private boolean enable;

    private ClickThresholdContract thresholdContract;

    public ClickUrl(String originUrl, boolean enable, ClickThresholdContract thresholdContract) {
        this.originUrl = originUrl;
        this.enable = enable;
        this.thresholdContract = thresholdContract;
    }

    public boolean isExpired() {
        ZonedDateTime expiredAt = thresholdContract.getExpiredAt();
        return expiredAt.isBefore(ZonedDateTime.now());
    }

    public boolean isExceedThresholdCount(long accumulatedRequestCount) {
        Long thresholdRequestCount = thresholdContract.getThresholdRequestCount();
        return thresholdRequestCount < accumulatedRequestCount;
    }
}
