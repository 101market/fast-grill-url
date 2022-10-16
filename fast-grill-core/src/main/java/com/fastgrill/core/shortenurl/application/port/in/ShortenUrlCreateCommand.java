package com.fastgrill.core.shortenurl.application.port.in;

import com.fastgrill.core.common.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;

import java.time.Instant;

@Getter
@Builder
public class ShortenUrlCreateCommand extends SelfValidating<ShortenUrlCreateCommand> {
    private final String url;
    private final Instant expiredAt;
    private final Long thresholdRequestCount;

    public ShortenUrlCreateCommand(String url, Instant expiredAt, Long thresholdRequestCount) {
        this.url = url;
        this.expiredAt = expiredAt;
        this.thresholdRequestCount = thresholdRequestCount;

        this.validateSelf();
    }
}
