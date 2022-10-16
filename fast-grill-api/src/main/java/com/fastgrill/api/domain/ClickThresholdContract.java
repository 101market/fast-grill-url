package com.fastgrill.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Getter
@RequiredArgsConstructor
@Builder
public class ClickThresholdContract implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant expiredAt;

    private Long thresholdRequestCount;

    @JsonCreator
    public ClickThresholdContract(Instant expiredAt, Long thresholdRequestCount) {
        this.expiredAt = expiredAt;
        this.thresholdRequestCount = thresholdRequestCount;
    }
}
