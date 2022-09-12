package com.fast.grill.click.adapter.out.messagebroker;

import com.fast.grill.click.application.port.ClickEventPublisherPort;
import com.fast.grill.common.EventProducerAdapter;
import com.fast.grill.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@PersistenceAdapter
public class ClickEventProducerAdapter implements ClickEventPublisherPort {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    // FIXME: application.yml 참조 오류 수정
    // @Value(value = "${kafka.topic.click}")
    private final String topicName = "fastgrill.click";

    private final Environment env;


    @Override
    public void publish(String shortenToken) {
        var clickEvent = ClickEvent.of(shortenToken);
        kafkaTemplate.send(topicName, clickEvent);
    }
}
