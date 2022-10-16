package com.fastgrill.api.application.service;

import com.fastgrill.api.domain.ClickEvent;
import com.fastgrill.api.application.port.in.ClickCommand;
import com.fastgrill.api.application.port.in.ClickUseCase;
import com.fastgrill.api.application.port.out.LoadClickUrlPort;
import com.fastgrill.api.application.port.out.ClickEventProducerPort;
import com.fastgrill.api.domain.ClickUrl;
import com.fastgrill.core.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class ClickService implements ClickUseCase {
    private final List<ClickValidator> validators;
    private final LoadClickUrlPort loadClickUrlPort;
    private final ClickEventProducerPort clickEventProducerPort;

    @Override
    public String clickShortenUrl(ClickCommand command) {
        ClickUrl clickUrl = loadClickUrlPort.loadClickUrl(command.getShortenToken());
        validators.forEach(validator -> validator.validate(clickUrl));

        var clickEvent = ClickEvent.of(command.getShortenToken());
        clickEventProducerPort.send(clickEvent);

        return clickUrl.getOriginUrl();
    }
}
