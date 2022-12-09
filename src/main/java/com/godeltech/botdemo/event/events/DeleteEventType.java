package com.godeltech.botdemo.event.events;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventType;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.service.DemoBotService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

@Component
@RequiredArgsConstructor
public class DeleteEventType implements EventType {

    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.DELETE;
    }

    @Override
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {
        demoBotService.execute(DeleteMessage.builder()
                        .chatId(customEvent.getMessage().getChatId())
                        .messageId(customEvent.getMessage().getMessageId())
                .build());
    }
}
