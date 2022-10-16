package com.fastgrill.core.shortenurl.application.port.in;

import com.fastgrill.core.shortenurl.domain.ShortenToken;

public interface ShortenUrlAdminUseCase {
    ShortenToken create(ShortenUrlCreateCommand command);
}
