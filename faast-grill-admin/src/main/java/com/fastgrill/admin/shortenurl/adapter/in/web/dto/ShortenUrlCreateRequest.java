package com.fastgrill.admin.shortenurl.adapter.in.web.dto;

import com.fastgrill.admin.shortenurl.adapter.in.web.CreateShortenUrlCommand;
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

    public CreateShortenUrlCommand toCommand() {
        return CreateShortenUrlCommand.builder().url(url).expiredAt(expiredAt).thresholdRequestCount(thresholdRequestCount).build();
    }
}
