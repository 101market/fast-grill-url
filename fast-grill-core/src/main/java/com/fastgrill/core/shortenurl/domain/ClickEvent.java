package com.fastgrill.core.shortenurl.domain;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ClickEvent extends Event {
    private String shortenToken;
    private String referer;
    private String userAgent;

    public ClickEvent(String id, String shortenToken, String referer, String userAgent) {
        super(id);
        this.shortenToken = shortenToken;
        this.referer = referer;
        this.userAgent = userAgent;
    }
}
