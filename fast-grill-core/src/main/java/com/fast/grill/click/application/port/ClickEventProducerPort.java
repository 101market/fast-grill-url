package com.fast.grill.click.application.port;

import com.fast.grill.click.adapter.out.messagebroker.ClickEvent;

public interface ClickEventProducerPort {
    void send(ClickEvent event);
}
