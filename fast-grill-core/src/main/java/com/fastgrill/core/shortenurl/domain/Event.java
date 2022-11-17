package com.fastgrill.core.shortenurl.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Event {
    private final String id;
    private final long timestamp;

    public Event() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
    }

    public Event(String id) {
        this.id = id;
        this.timestamp = System.currentTimeMillis();
    }
}
