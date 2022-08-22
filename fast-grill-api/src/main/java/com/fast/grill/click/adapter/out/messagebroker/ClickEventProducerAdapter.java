package com.fast.grill.click.adapter.out.messagebroker;

import com.fast.grill.click.application.port.ClickEventPublisherPort;
import com.fast.grill.common.EventProducerAdapter;
import com.fast.grill.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
@EventProducerAdapter
public class ClickEventProducerAdapter implements ClickEventPublisherPort {
    private final KafkaTemplate<String, ClickEvent> kafkaTemplate;

    @Value(value = "${kafka.topic.name}")
    private final String topicName;

    @Override
    public void publish(String shortenToken) {
        var clickEvent = ClickEvent.of(shortenToken);
        kafkaTemplate.send(topicName, clickEvent);
    }
}
