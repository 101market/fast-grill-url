package com.fastgrill.api.application.port.in;

import com.fastgrill.api.domain.ClickEvent;
import com.fastgrill.core.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public class ClickCommand extends SelfValidating<ClickCommand> {
    @NotEmpty
    private final String shortenToken;

    @NotEmpty
    private final String trackId;

    private final String referer;

    @NotNull
    private final String userAgent;

    private final String requestId;

    public ClickCommand(String shortenToken, String trackId, String referer, String userAgent, String requestId) {
        this.shortenToken = shortenToken;
        this.trackId = trackId;
        this.referer = referer;
        this.userAgent = userAgent;
        this.requestId = requestId;
        this.validateSelf();
    }

    public ClickEvent toEvent() {
        return new ClickEvent(requestId, trackId, shortenToken, referer, userAgent);
    }
}
