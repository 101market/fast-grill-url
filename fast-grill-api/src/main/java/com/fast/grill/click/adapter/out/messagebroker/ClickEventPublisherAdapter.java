package com.fast.grill.click.adapter.out.messagebroker;

import com.fast.grill.click.application.port.ClickEventPublisherPort;

public class ClickEventPublisherAdapter implements ClickEventPublisherPort {
    @Override
    public void publish(String shortenToken) {
        // TODO: kafka message 발행
        ClickEvent.of(shortenToken);
    }
}
