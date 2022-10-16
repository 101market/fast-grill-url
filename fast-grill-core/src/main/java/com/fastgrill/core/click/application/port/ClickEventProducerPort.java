package com.fastgrill.core.click.application.port;

import com.fastgrill.core.click.adapter.out.messagebroker.ClickEvent;

public interface ClickEventProducerPort {
    void send(ClickEvent event);
}
