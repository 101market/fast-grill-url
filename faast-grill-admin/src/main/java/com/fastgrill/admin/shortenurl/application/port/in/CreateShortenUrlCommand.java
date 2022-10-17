package com.fastgrill.admin.shortenurl.application.port.in;

import com.fastgrill.core.common.SelfValidating;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class CreateShortenUrlCommand extends SelfValidating<CreateShortenUrlCommand> {
    private final String originUrl;
    private final Instant expiredAt;
    private final Long thresholdRequestCount;

    public CreateShortenUrlCommand(String originUrl, Instant expiredAt, Long thresholdRequestCount) {
        this.originUrl = originUrl;
        this.expiredAt = expiredAt;
        this.thresholdRequestCount = thresholdRequestCount;

        this.validateSelf();
    }

    public ShortenUrlJpaEntity toEntity(){
        return ShortenUrlJpaEntity.create(originUrl, expiredAt, thresholdRequestCount);
    }
}
