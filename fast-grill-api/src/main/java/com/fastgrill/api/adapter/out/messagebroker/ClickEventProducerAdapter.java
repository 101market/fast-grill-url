package com.fastgrill.api.adapter.out.messagebroker;

import com.fastgrill.api.application.port.out.ClickEventProducerPort;
import com.fastgrill.api.domain.ClickEvent;
import com.fastgrill.core.shortenurl.domain.Event;
import com.fastgrill.core.common.PersistenceAdapter;
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
