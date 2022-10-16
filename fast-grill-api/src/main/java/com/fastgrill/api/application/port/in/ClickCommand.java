package com.fastgrill.api.application.port.in;

import com.fastgrill.core.common.SelfValidating;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotEmpty;

@Value
@EqualsAndHashCode(callSuper = false)
public class ClickCommand extends SelfValidating<ClickCommand> {
    @NotEmpty
    private final String shortenToken;

    public ClickCommand(String shortenToken) {
        this.shortenToken = shortenToken;
        this.validateSelf();
    }
}
