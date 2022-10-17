package com.fastgrill.admin.shortenurl.application.port.in;

import com.fastgrill.core.common.SelfValidating;
import com.fastgrill.core.shortenurl.adapter.out.persistence.ShortenUrlJpaEntity;
import lombok.*;

import java.time.Instant;

@Getter
public class ModifyShortenUrlCommand extends SelfValidating<ModifyShortenUrlCommand> {
    private Instant expiredAt;
    private Long thresholdRequestCount;

    @Builder
    public ModifyShortenUrlCommand(Instant expiredAt, Long thresholdRequestCount) {
        this.expiredAt = expiredAt;
        this.thresholdRequestCount = thresholdRequestCount;

        this.validateSelf();
    }
}
