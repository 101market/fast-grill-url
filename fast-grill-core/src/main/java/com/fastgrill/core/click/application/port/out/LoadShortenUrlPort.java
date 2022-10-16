package com.fastgrill.core.click.application.port.out;

import com.fastgrill.core.click.domain.ClickUrl;

public interface LoadShortenUrlPort {
    ClickUrl loadClickUrl(String shortenToken);
}
