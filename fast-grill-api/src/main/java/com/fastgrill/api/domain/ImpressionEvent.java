package com.fastgrill.api.domain;


import com.fastgrill.core.shortenurl.domain.Event;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ImpressionEvent extends Event {
    private String shortenToken;
    private String trackId;
    private String referer;
    private String userAgent;

    public ImpressionEvent(String id, String shortenToken, String trackId, String referer, String userAgent) {
        super(id);
        this.shortenToken = shortenToken;
        this.trackId = trackId;
        this.referer = referer;
        this.userAgent = userAgent;
    }
}
