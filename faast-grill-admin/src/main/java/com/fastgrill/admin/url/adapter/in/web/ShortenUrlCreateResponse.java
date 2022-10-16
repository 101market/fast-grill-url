package com.fastgrill.admin.url.adapter.in.web;

import com.fastgrill.core.shortenurl.domain.ShortenToken;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Builder
public class ShortenUrlCreateResponse {
    private String shortenUrl;

    public static ShortenUrlCreateResponse of(ShortenToken shortenToken){
        return ShortenUrlCreateResponse.builder()
                .shortenUrl(shortenToken.getUrl())
                .build();
    }
}
