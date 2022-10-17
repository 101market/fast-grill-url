package com.fastgrill.admin.shortenurl.adapter.in.web.dto;

import com.fastgrill.admin.shortenurl.application.port.in.CreateShortenUrlCommand;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Builder
public class CreateShortenUrlRequest {
    @NotEmpty
    private final String originUrl;
    private final Instant expiredAt;
    private final Long thresholdRequestCount;

    public CreateShortenUrlCommand toCommand() {
        return CreateShortenUrlCommand.builder().originUrl(originUrl).expiredAt(expiredAt).thresholdRequestCount(thresholdRequestCount).build();
    }
}
