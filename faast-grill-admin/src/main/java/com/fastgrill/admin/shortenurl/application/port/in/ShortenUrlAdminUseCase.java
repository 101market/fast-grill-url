package com.fastgrill.admin.shortenurl.application.port.in;

import com.fastgrill.admin.shortenurl.adapter.in.web.CreateShortenUrlCommand;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;

public interface ShortenUrlAdminUseCase {
    ShortenUrl create(CreateShortenUrlCommand command);
}
