package com.fastgrill.core.shortenurl.application.port.out;

public interface ShortenUrlHitsPort {
    long getHits(String shortenToken);

    void increaseHits(String shortenToken);
}
