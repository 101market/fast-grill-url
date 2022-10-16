package com.fastgrill.admin.shortenurl.application.service;

import com.fastgrill.admin.shortenurl.application.port.in.ShortenUrlAdminUseCase;
import com.fastgrill.admin.shortenurl.adapter.in.web.CreateShortenUrlCommand;
import com.fastgrill.admin.shortenurl.application.port.out.ShortenUrlPort;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.common.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class ShortenUrlAdminService implements ShortenUrlAdminUseCase {
    private final ShortenUrlPort shortenUrlPort;

    @Override
    public ShortenUrl create(CreateShortenUrlCommand command) {
        return shortenUrlPort.create(command);
    }
}
