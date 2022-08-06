package com.fast.grill.click.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClickUrl {
    private String originUrl;

    private boolean enable;

    private ClickThresholdContract thresholdContract;

    public ClickUrl(String originUrl, boolean enable, ClickThresholdContract thresholdContract){
        this.originUrl = originUrl;
        this.enable = enable;
        this.thresholdContract = thresholdContract;
    }
}
