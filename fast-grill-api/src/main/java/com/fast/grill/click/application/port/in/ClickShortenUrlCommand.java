package com.fast.grill.click.application.port.in;

import com.fast.grill.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
@EqualsAndHashCode(callSuper = false)
public class ClickShortenUrlCommand extends SelfValidating<ClickShortenUrlCommand> {
    @NotEmpty
    private final String shortenToken;

    public ClickShortenUrlCommand(String shortenToken) {
        this.shortenToken = shortenToken;
        this.validateSelf();
    }
}
