package com.fastgrill.admin.url.adapter.in.web;

import com.fastgrill.core.shortenurl.application.port.in.ShortenUrlCreateCommand;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Builder
public class ShortenUrlCreateRequest {
    @NotEmpty
    private final String url;
    private final Instant expiredAt;
    private final Long thresholdRequestCount;

    public ShortenUrlCreateCommand toCommand() {
        return ShortenUrlCreateCommand.builder().url(url).expiredAt(expiredAt).thresholdRequestCount(thresholdRequestCount).build();
    }
}
