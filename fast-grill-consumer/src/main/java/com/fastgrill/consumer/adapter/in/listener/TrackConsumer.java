package com.fastgrill.consumer.adapter.in.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TrackConsumer {

    @KafkaListener(topics = "output-topic")
    public void consume(String event, Acknowledgment ack) {
        log.info("Consume the event {}", event);
        ack.acknowledge();
    }
}
