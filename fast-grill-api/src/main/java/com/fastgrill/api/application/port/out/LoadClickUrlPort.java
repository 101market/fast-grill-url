package com.fastgrill.api.application.port.out;

import com.fastgrill.api.domain.ClickUrl;

public interface LoadClickUrlPort {
    ClickUrl loadClickUrl(String shortenToken);
}
