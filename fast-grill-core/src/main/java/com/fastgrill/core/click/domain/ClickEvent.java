package com.fastgrill.core.click.domain;


import lombok.Getter;

@Getter
public class ClickEvent extends Event {
    private String shortenToken;

    public ClickEvent(String shortenToken) {
        super();
        this.shortenToken = shortenToken;
    }

    public static ClickEvent of(String shortenToken) {
        return new ClickEvent(shortenToken);
    }
}
