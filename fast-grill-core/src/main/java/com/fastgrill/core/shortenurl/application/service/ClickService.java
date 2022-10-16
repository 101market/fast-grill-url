package com.fastgrill.core.shortenurl.application.service;

import com.fastgrill.core.shortenurl.domain.ClickEvent;
import com.fastgrill.core.shortenurl.application.port.in.ClickCommand;
import com.fastgrill.core.shortenurl.application.port.in.ClickUseCase;
import com.fastgrill.core.shortenurl.application.port.out.LoadShortenUrlPort;
import com.fastgrill.core.shortenurl.application.port.out.ClickEventProducerPort;
import com.fastgrill.core.shortenurl.domain.ClickUrl;
import com.fastgrill.core.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class ClickService implements ClickUseCase {
    private final List<ClickValidator> validators;
    private final LoadShortenUrlPort loadShortenUrlPort;
    private final ClickEventProducerPort clickEventProducerPort;

    @Override
    public String clickShortenUrl(ClickCommand command) {
        ClickUrl clickUrl = loadShortenUrlPort.loadClickUrl(command.getShortenToken());
        validators.forEach(validator -> validator.validate(clickUrl));

        var clickEvent = ClickEvent.of(command.getShortenToken());
        clickEventProducerPort.send(clickEvent);

        return clickUrl.getOriginUrl();
    }
}
