package com.fastgrill.api.application.port.out;

import com.fastgrill.api.domain.ClickEvent;
import com.fastgrill.api.domain.ConversionEvent;
import com.fastgrill.api.domain.ImpressionEvent;

public interface TrackingEventProducerPort {
    void send(ImpressionEvent event);

    void send(ClickEvent event);

    void send(ConversionEvent event);
}
