package com.fastgrill.api.application.port.out;

import com.fastgrill.api.domain.ClickUrl;

public interface ShortenUrlPort {
    ClickUrl loadClickUrl(String shortenToken);
}
