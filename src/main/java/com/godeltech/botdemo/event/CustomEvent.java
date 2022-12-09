package com.godeltech.botdemo.event;

import lombok.Builder;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Message;

@Getter
@Builder
public class CustomEvent {
    private Message message;
    private Type type;

    public CustomEvent(Message message, Type type) {
        this.message = message;
        this.type = type;
    }
}
