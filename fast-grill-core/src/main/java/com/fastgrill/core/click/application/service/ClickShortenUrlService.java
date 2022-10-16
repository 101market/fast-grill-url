package com.fastgrill.core.click.application.service;

import com.fastgrill.core.click.adapter.out.messagebroker.ClickEvent;
import com.fastgrill.core.click.application.port.in.ClickShortenUrlCommand;
import com.fastgrill.core.click.application.port.in.ClickShortenUrlUseCase;
import com.fastgrill.core.click.application.port.out.LoadShortenUrlPort;
import com.fastgrill.core.click.application.port.ClickEventProducerPort;
import com.fastgrill.core.click.domain.ClickUrl;
import com.fastgrill.core.common.UseCase;
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
