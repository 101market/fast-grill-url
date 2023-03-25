package com.fastgrill.api.domain;


import com.fastgrill.core.shortenurl.domain.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConversionEvent extends Event {
    private String shortenToken;
    private String referer;
    private String userAgent;

    public ConversionEvent(String id, String shortenToken, String referer, String userAgent) {
        super(id);
        this.shortenToken = shortenToken;
        this.referer = referer;
        this.userAgent = userAgent;
    }
}
