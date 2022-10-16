package com.fastgrill.admin.shortenurl.adapter.in.web;

import com.fastgrill.core.common.SelfValidating;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class CreateShortenUrlCommand extends SelfValidating<CreateShortenUrlCommand> {
    private final String url;
    private final Instant expiredAt;
    private final Long thresholdRequestCount;

    public CreateShortenUrlCommand(String url, Instant expiredAt, Long thresholdRequestCount) {
        this.url = url;
        this.expiredAt = expiredAt;
        this.thresholdRequestCount = thresholdRequestCount;

        this.validateSelf();
    }

    public ShortenUrlJpaEntity toEntity(){
        return ShortenUrlJpaEntity.create(url, expiredAt, thresholdRequestCount);
    }
}
