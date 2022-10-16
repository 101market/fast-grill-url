package com.fastgrill.core.shortenurl.application.port.out;

import com.fastgrill.core.shortenurl.domain.ClickUrl;

public interface LoadShortenUrlPort {
    ClickUrl loadClickUrl(String shortenToken);
}
