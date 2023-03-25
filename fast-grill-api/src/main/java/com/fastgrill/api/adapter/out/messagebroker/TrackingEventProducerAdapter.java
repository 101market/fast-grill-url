package com.fastgrill.api.adapter.out.messagebroker;

import com.fastgrill.api.application.port.out.TrackingEventProducerPort;
import com.fastgrill.api.domain.ClickEvent;
import com.fastgrill.api.domain.ConversionEvent;
import com.fastgrill.api.domain.ImpressionEvent;
import com.fastgrill.core.common.PersistenceAdapter;
import com.fastgrill.core.shortenurl.domain.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
@PersistenceAdapter
@Slf4j
public class TrackingEventProducerAdapter implements TrackingEventProducerPort {
    private final KafkaTemplate<String, Event> kafkaTemplate;

    @Value(value = "${kafka.topic.impression}")
    private String impressionTopic;

    @Value(value = "${kafka.topic.click}")
    private String clickTopic;

    @Value(value = "${kafka.topic.conversion}")
    private String conversionTopic;

    @Override
    public void send(ImpressionEvent event) {
        try {
            kafkaTemplate.send(impressionTopic, event);
            log.info("[Kafka enqueued topic: {}, message: {}", impressionTopic, event);
        } catch (Exception e) {
            log.error("[Kafka failed topic: {}, message: {}", impressionTopic, event);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void send(ClickEvent event) {
        try {
            kafkaTemplate.send(clickTopic, event);
            log.info("[Kafka enqueued topic: {}, message: {}", clickTopic, event);
        } catch (Exception e) {
            log.error("[Kafka failed topic: {}, message: {}", clickTopic, event);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void send(ConversionEvent event) {
        try {
            kafkaTemplate.send(conversionTopic, event);
            log.info("[Kafka enqueued topic: {}, message: {}", conversionTopic, event);
        } catch (Exception e) {
            log.error("[Kafka failed topic: {}, message: {}", conversionTopic, event);
            throw new RuntimeException(e);
        }
    }
}
