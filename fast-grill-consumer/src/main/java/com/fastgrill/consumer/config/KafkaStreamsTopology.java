package com.fastgrill.consumer.config;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaStreamsTopology {

    @Value(value = "${spring.kafka.topic.impression}")
    private String impressionTopic;

    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, String> stream = streamsBuilder.stream(impressionTopic);
        stream.mapValues(value -> value.toUpperCase())
                .to("output-topic");
        return stream;
    }
}

