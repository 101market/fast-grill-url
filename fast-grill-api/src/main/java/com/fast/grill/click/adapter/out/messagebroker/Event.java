package com.fast.grill.click.adapter.out.messagebroker;

import lombok.Getter;

@Getter
public abstract class Event {
    private long timestamp;

    public Event() {
        this.timestamp = System.currentTimeMillis();
    }

}
