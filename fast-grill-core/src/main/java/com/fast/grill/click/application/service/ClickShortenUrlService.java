package com.fast.grill.click.application.service;

import com.fast.grill.click.adapter.out.messagebroker.ClickEvent;
import com.fast.grill.click.application.port.in.ClickShortenUrlCommand;
import com.fast.grill.click.application.port.in.ClickShortenUrlUseCase;
import com.fast.grill.click.application.port.out.LoadShortenUrlPort;
import com.fast.grill.click.application.port.ClickEventProducerPort;
import com.fast.grill.click.domain.ClickUrl;
import com.fast.grill.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class ClickShortenUrlService implements ClickShortenUrlUseCase {
    private final List<ClickValidator> validators;
    private final LoadShortenUrlPort loadShortenUrlPort;
    private final ClickEventProducerPort clickEventProducerPort;

    @Override
    public String clickShortenUrl(ClickShortenUrlCommand command) {
        ClickUrl clickUrl = loadShortenUrlPort.loadClickUrl(command.getShortenToken());
        validators.forEach(validator -> validator.validate(clickUrl));

        var clickEvent = ClickEvent.of(command.getShortenToken());
        clickEventProducerPort.send(clickEvent);

        return clickUrl.getOriginUrl();
    }
}
