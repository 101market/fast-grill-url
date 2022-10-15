package com.fast.grill.click.adapter.out.messagebroker;

import com.fast.grill.click.application.port.ClickEventProducerPort;
import com.fast.grill.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
@PersistenceAdapter
public class ClickEventProducerAdapter implements ClickEventProducerPort {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    @Value(value = "${kafka.topic.click}")
    private String topicName;

    @Override
    public void send(ClickEvent event) {
        kafkaTemplate.send(topicName, event);
    }
}
