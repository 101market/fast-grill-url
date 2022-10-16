package com.fastgrill.api.application.port.out;

import com.fastgrill.api.domain.ClickEvent;

public interface ClickEventProducerPort {
    void send(ClickEvent event);
}
