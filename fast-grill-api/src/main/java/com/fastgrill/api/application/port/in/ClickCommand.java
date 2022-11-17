package com.fastgrill.api.application.port.in;

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
    @NotNull
    private final Device device;

    public ClickCommand(String shortenToken, Device device) {
        this.shortenToken = shortenToken;
        this.device = device;
        this.validateSelf();
    }
}
