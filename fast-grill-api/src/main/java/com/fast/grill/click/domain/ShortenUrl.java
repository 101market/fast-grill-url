package com.fast.grill.click.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ShortenUrl {
    private String shortenToken;

    private String originUrl;

    private ZonedDateTime expiredAt;
}
