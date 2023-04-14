package com.fastgrill.core.shortenurl.domain;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ImpressionEvent extends Event {
    private String shortenToken;
    private String referer;
    private String userAgent;

    public ImpressionEvent(String id, String shortenToken, String referer, String userAgent) {
        super(id);
        this.shortenToken = shortenToken;
        this.referer = referer;
        this.userAgent = userAgent;
    }
}
