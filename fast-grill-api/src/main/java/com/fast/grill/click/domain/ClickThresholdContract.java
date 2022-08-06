package com.fast.grill.click.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@RequiredArgsConstructor
public class ClickThresholdContract {
    private ZonedDateTime expiredAt;

    private Long thresholdRequestCount;

    public ClickThresholdContract(ZonedDateTime expiredAt, Long thresholdRequestCount){
        this.expiredAt = expiredAt;
        this.thresholdRequestCount = thresholdRequestCount;
    }
}
