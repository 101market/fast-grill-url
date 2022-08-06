package com.fast.grill.click.application.port.out;

import com.fast.grill.click.domain.ClickUrl;

public interface LoadShortenUrlPort {
    ClickUrl loadClickUrl(String shortenToken);
}
