package com.fastgrill.api.application.service.validator;

import com.fastgrill.core.shortenurl.application.port.out.ShortenUrlHitsPort;
import com.fastgrill.api.application.service.ClickValidator;
import com.fastgrill.api.application.service.exception.ClosedUrlClickException;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.DomainComponent;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class ThresholdClickValidatorImpl implements ClickValidator {
    private final ShortenUrlHitsPort shortenUrlHitsPort;

    @Override
    public void validate(ClickUrl clickUrl) {
        if (clickUrl.isExpired()) {
            throw new ClosedUrlClickException();
        }

        var hits = shortenUrlHitsPort.getHits(clickUrl.getShortenToken());
        if (clickUrl.isExceedThresholdCount(hits)){
            throw new ClosedUrlClickException();
        }
    }
}
