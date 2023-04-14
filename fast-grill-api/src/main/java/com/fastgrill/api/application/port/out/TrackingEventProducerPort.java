package com.fastgrill.api.application.port.out;

import com.fastgrill.core.shortenurl.domain.ClickEvent;
import com.fastgrill.core.shortenurl.domain.ImpressionEvent;

public interface TrackingEventProducerPort {
    void send(ImpressionEvent event);

    void send(ClickEvent event);
}
