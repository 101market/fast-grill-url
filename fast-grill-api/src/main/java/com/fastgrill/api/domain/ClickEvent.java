package com.fastgrill.api.domain;


import com.fastgrill.core.shortenurl.domain.Event;
import lombok.Getter;
import lombok.ToString;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DevicePlatform;

@Getter
@ToString
public class ClickEvent extends Event {
    private String shortenToken;
    private Device device;


    public ClickEvent(String shortenToken, Device device) {
        super();
        this.shortenToken = shortenToken;
        this.device = device;
    }

    public static ClickEvent of(String shortenToken, Device device) {
        return new ClickEvent(shortenToken, device);
    }
}
