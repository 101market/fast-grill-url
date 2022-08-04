package com.fast.grill.click.application.service;

import com.fast.grill.click.application.port.in.ClickShortenUrlCommand;
import com.fast.grill.click.application.port.in.ClickShortenUrlUseCase;
import com.fast.grill.common.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ClickShortenUrlService implements ClickShortenUrlUseCase {
    @Override
    public String clickShortenUrl(ClickShortenUrlCommand command) {
        return "https://github.com/101market/fast-grill-url";
    }
}
