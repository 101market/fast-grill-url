package com.fast.grill.click.adapter.out.messagebroker;

import com.fast.grill.click.application.port.ClickEventPublisherPort;
import com.fast.grill.common.EventProducerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@EventProducerAdapter
@Service
public class ClickEventProducerAdapter implements ClickEventPublisherPort {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    // @Value(value = "${kafka.topic.click}")
    private final String topicName = "fastgrill.click";

    @Override
    public void publish(String shortenToken) {
        var clickEvent = ClickEvent.of(shortenToken);
        kafkaTemplate.send(topicName, clickEvent);
    }
}
