package com.fastgrill.api.domain;


import com.fastgrill.core.shortenurl.domain.Event;
import lombok.Getter;
import lombok.ToString;
import org.springframework.mobile.device.Device;

@Getter
@ToString
public class ClickEvent extends Event {
    private String shortenToken;
    private String referer;
    private String userAgent;

    public ClickEvent(String shortenToken, String referer, String userAgent) {
        super();
        this.shortenToken = shortenToken;
        this.referer = referer;
        this.userAgent = userAgent;
    }
}
