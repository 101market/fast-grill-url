package com.fastgrill.consumer.adapter.in.streams;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrackProcessor {
    private static final Serde<String> STRING_SERDE = Serdes.String();

    @Value(value = "${kafka.topic.impression}")
    private String impressionTopic;

    @Value(value = "${kafka.topic.click}")
    private String clickTopic;

    @Value(value = "${kafka.topic.conversion}")
    private String conversionTopic;


    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> messageStream = streamsBuilder
                .stream(impressionTopic, Consumed.with(STRING_SERDE, STRING_SERDE));

        KTable<String, Long> refererCounts = messageStream
                .mapValues((ValueMapper<String, String>) String::toLowerCase)
                .groupBy((key, referer) -> referer, Grouped.with(STRING_SERDE, STRING_SERDE))
                .count();
        
        // FIXME: 테스트용 하드코딩 토픽  
        refererCounts.toStream().to("referer-topic");
    }
}
