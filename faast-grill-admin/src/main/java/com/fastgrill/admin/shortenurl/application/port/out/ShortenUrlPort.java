package com.fastgrill.admin.shortenurl.application.port.out;

import com.fastgrill.admin.shortenurl.application.port.in.CreateShortenUrlCommand;
import com.fastgrill.admin.shortenurl.application.port.in.ModifyShortenUrlCommand;
import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShortenUrlPort {
    ShortenUrl create(CreateShortenUrlCommand command);

    Page<ShortenUrl> list(Pageable pageable);

    ShortenUrl modify(ModifyShortenUrlCommand command);

    void enableUrl(Long shortenUrlId);

    void disableUrl(Long shortenUrlId);
}
