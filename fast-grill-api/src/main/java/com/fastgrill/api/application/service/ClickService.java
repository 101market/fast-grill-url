package com.fastgrill.api.application.service;

import com.fastgrill.api.domain.ClickEvent;
import com.fastgrill.api.application.port.in.ClickCommand;
import com.fastgrill.api.application.port.in.ClickUseCase;
import com.fastgrill.api.application.port.out.ShortenUrlPort;
import com.fastgrill.api.application.port.out.ClickEventProducerPort;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.UseCase;
import com.fastgrill.core.shortenurl.application.port.out.ShortenUrlHitsPort;
import com.fastgrill.core.shortenurl.application.service.specificaiton.AbstractSpecification;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class ClickService implements ClickUseCase {
    private final List<AbstractSpecification<ClickUrl>> specifications;
    private final ShortenUrlPort shortenUrlPort;
    private final ShortenUrlHitsPort shortenUrlHitsPort;
    private final ClickEventProducerPort clickEventProducerPort;

    @Override
    public String clickShortenUrl(ClickCommand command) {
        ClickUrl clickUrl = shortenUrlPort.loadClickUrl(command.getShortenToken());
        specifications.forEach(specification -> specification.check(clickUrl));

        shortenUrlHitsPort.increaseHits(command.getShortenToken());

        var clickEvent = command.toEvent();
        clickEventProducerPort.send(clickEvent);

        return clickUrl.getOriginUrl();
    }
}
