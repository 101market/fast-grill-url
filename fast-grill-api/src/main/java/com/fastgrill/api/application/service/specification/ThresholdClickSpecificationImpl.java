package com.fastgrill.api.application.service.specification;

import com.fastgrill.api.application.service.exception.ClosedUrlClickException;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.DomainComponent;
import com.fastgrill.core.shortenurl.application.port.out.ShortenUrlHitsPort;
import com.fastgrill.core.shortenurl.application.service.specificaiton.AbstractSpecification;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class ThresholdClickSpecificationImpl extends AbstractSpecification<ClickUrl> {
    private final ShortenUrlHitsPort shortenUrlHitsPort;

    @Override
    public boolean isSatisfiedBy(ClickUrl clickUrl) {
        var hits = shortenUrlHitsPort.getHits(clickUrl.getShortenToken());
        return !clickUrl.isExceedThresholdCount(hits);
    }

    @Override
    public void check(ClickUrl clickUrl) throws ClosedUrlClickException {
        if (isSatisfiedBy(clickUrl)) return;
        throw new ClosedUrlClickException();
    }
}
