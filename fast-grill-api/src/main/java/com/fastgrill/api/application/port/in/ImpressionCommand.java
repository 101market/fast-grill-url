package com.fastgrill.api.application.port.in;

import com.fastgrill.core.common.SelfValidating;
import com.fastgrill.core.shortenurl.domain.ImpressionEvent;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public class ImpressionCommand extends SelfValidating<ImpressionCommand> {
    @NotEmpty
    private final String shortenToken;

    private final String referer;

    @NotNull
    private final String userAgent;

    private final String requestId;

    public ImpressionCommand(String shortenToken, String referer, String userAgent, String requestId) {
        this.shortenToken = shortenToken;
        this.referer = referer;
        this.userAgent = userAgent;
        this.requestId = requestId;
        this.validateSelf();
    }

    public ImpressionEvent toEvent() {
        return new ImpressionEvent(requestId, shortenToken, referer, userAgent);
    }
}
