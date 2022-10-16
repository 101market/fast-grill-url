package com.fastgrill.core.click.application.port.out;

import com.fastgrill.core.click.domain.ClickEvent;

public interface ClickEventProducerPort {
    void send(ClickEvent event);
}
