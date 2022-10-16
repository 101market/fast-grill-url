package com.fastgrill.core.shortenurl.application.port.out;

import com.fastgrill.core.shortenurl.domain.ClickUrl;

public interface LoadClickUrlPort {
    ClickUrl loadClickUrl(String shortenToken);
}
