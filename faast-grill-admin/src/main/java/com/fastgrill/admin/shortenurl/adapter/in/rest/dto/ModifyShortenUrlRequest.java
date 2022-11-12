package com.fastgrill.admin.shortenurl.adapter.in.rest.dto;

import com.fastgrill.admin.shortenurl.application.port.in.ModifyShortenUrlCommand;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class ModifyShortenUrlRequest {
    private Instant expiredAt;
    private Long thresholdRequestCount;

    public ModifyShortenUrlCommand toCommand() {
        return ModifyShortenUrlCommand.builder()
                .expiredAt(expiredAt)
                .thresholdRequestCount(thresholdRequestCount)
                .build();
    }
}
