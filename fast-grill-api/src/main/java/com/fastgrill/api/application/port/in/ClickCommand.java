package com.fastgrill.api.application.port.in;

import com.fastgrill.api.domain.ClickEvent;
import com.fastgrill.core.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.mobile.device.Device;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public class ClickCommand extends SelfValidating<ClickCommand> {
    @NotEmpty
    private final String shortenToken;

    private final String referer;

    @NotNull
    private final String userAgent;

    public ClickCommand(String shortenToken, String referer, String userAgent) {
        this.shortenToken = shortenToken;
        this.referer = referer;
        this.userAgent = userAgent;
        this.validateSelf();
    }

    public ClickEvent toEvent() {
        return new ClickEvent(shortenToken, referer, userAgent);
    }
}
