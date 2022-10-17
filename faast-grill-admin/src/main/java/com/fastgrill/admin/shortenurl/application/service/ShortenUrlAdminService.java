package com.fastgrill.admin.shortenurl.application.service;

import com.fastgrill.admin.shortenurl.application.port.in.ModifyShortenUrlCommand;
import com.fastgrill.admin.shortenurl.application.port.in.ShortenUrlAdminUseCase;
import com.fastgrill.admin.shortenurl.application.port.in.CreateShortenUrlCommand;
import com.fastgrill.admin.shortenurl.application.port.out.ShortenUrlPort;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import com.fastgrill.core.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
@UseCase
public class ShortenUrlAdminService implements ShortenUrlAdminUseCase {
    private final ShortenUrlPort shortenUrlPort;

    @Override
    public ShortenUrl create(CreateShortenUrlCommand command) {
        return shortenUrlPort.create(command);
    }

    @Override
    public Page<ShortenUrl> list(Pageable pageable) {
        return shortenUrlPort.list(pageable);
    }

    @Override
    public ShortenUrl modify(ModifyShortenUrlCommand command) {
        return shortenUrlPort.modify(command);
    }

    @Override
    public void enableUrl(Long shortenUrlId) {
        shortenUrlPort.enableUrl(shortenUrlId);
    }

    @Override
    public void disableUrl(Long shortenUrlId) {
        shortenUrlPort.disableUrl(shortenUrlId);
    }
}
