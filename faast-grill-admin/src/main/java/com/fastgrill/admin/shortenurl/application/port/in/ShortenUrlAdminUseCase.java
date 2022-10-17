package com.fastgrill.admin.shortenurl.application.port.in;

import com.fastgrill.admin.shortenurl.domain.ShortenUrl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShortenUrlAdminUseCase {
    ShortenUrl create(CreateShortenUrlCommand command);

    Page<ShortenUrl> list(Pageable pageable);

    ShortenUrl modify(ModifyShortenUrlCommand command);

    void enableUrl(Long shortenUrlId);

    void disableUrl(Long shortenUrlId);
}
