package com.fast.grill.click.application.service;

import com.fast.grill.click.application.port.in.ClickShortenUrlCommand;
import com.fast.grill.click.application.port.in.ClickShortenUrlUseCase;
import com.fast.grill.click.application.port.out.LoadShortenUrlPort;
import com.fast.grill.click.domain.ClickUrl;
import com.fast.grill.common.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ClickShortenUrlService implements ClickShortenUrlUseCase {
    private final LoadShortenUrlPort loadShortenUrlPort;

    @Override
    public String clickShortenUrl(ClickShortenUrlCommand command) {
        ClickUrl clickUrl = loadShortenUrlPort.loadClickUrl(command.getShortenToken());
        validate(clickUrl);

//      TODO:  click kafka event 발행하기
        return clickUrl.getOriginUrl();
    }

    private void validate(ClickUrl clickUrl){
//    TODO    1. click url disable 여부,
//        enable이면 예외
//        TODO. 2. 호출수 제한, expired check
        checkThreshold(clickUrl);
    }

    private void checkThreshold(ClickUrl clickUrl) {
//        throw new ThresholdExceededException();
    }
}
