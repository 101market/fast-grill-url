package com.fastgrill.core.shortenurl.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class ShortenToken {
    private String value;

    public String getUrl() {
        return "http://localhost:8000/api/v1/" + value;
    }
}
