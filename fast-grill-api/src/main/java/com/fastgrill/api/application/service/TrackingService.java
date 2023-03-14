package com.fastgrill.api.application.service;

import com.fastgrill.api.application.port.in.ClickCommand;
import com.fastgrill.api.application.port.in.ImpressionCommand;
import com.fastgrill.api.application.port.in.TrackingUseCase;
import com.fastgrill.api.application.port.out.ShortenUrlPort;
import com.fastgrill.api.application.port.out.TrackingEventProducerPort;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.UseCase;
import com.fastgrill.core.shortenurl.application.port.out.ShortenUrlHitsPort;
import com.fastgrill.core.shortenurl.application.service.specificaiton.AbstractSpecification;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class TrackingService implements TrackingUseCase {
    private final List<AbstractSpecification<ClickUrl>> specifications;
    private final ShortenUrlPort shortenUrlPort;
    private final ShortenUrlHitsPort shortenUrlHitsPort;
    private final TrackingEventProducerPort trackingEventProducerPort;

    @Override
    public void impression(ImpressionCommand command) {
        var impressionEvent = command.toEvent();
        trackingEventProducerPort.send(impressionEvent);
    }

    @Override
    public String click(ClickCommand command) {
        ClickUrl clickUrl = shortenUrlPort.loadClickUrl(command.getShortenToken());
        specifications.forEach(specification -> specification.check(clickUrl));

        shortenUrlHitsPort.increaseHits(command.getShortenToken());

        var clickEvent = command.toEvent();
        trackingEventProducerPort.send(clickEvent);

        return clickUrl.getOriginUrl();
    }
}
