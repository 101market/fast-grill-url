package com.fastgrill.admin.shortenurl.application.port.out;

import com.fastgrill.admin.shortenurl.adapter.in.web.CreateShortenUrlCommand;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;

public interface ShortenUrlPort {
    ShortenUrl create(CreateShortenUrlCommand command);
}
