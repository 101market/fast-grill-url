package com.fastgrill.core.shortenurl.application.service;

import com.fastgrill.core.common.UseCase;
import com.fastgrill.core.shortenurl.application.port.in.ShortenUrlAdminUseCase;
import com.fastgrill.core.shortenurl.application.port.in.ShortenUrlCreateCommand;
import com.fastgrill.core.shortenurl.domain.ShortenToken;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ShortenUrlAdminService implements ShortenUrlAdminUseCase {
    @Override
    public ShortenToken create(ShortenUrlCreateCommand command) {
        return null;
    }
}
