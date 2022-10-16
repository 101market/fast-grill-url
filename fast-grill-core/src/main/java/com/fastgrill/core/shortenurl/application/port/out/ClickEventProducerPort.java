package com.fastgrill.core.shortenurl.application.port.out;

import com.fastgrill.core.shortenurl.domain.ClickEvent;

public interface ClickEventProducerPort {
    void send(ClickEvent event);
}
