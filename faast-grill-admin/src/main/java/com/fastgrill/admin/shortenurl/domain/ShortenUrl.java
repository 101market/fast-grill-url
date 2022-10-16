package com.fastgrill.admin.shortenurl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@AllArgsConstructor
@Builder
public class ShortenUrl {
    private Long id;
    private String shortenToken;
    private String originUrl;
    private Instant expiredAt;
    private Long thresholdRequestCount;

    public String getShortenUrl(){
        return "localhost:8000/api/v1/" + shortenToken;
    }
}
