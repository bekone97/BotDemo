package com.godeltech.botdemo.event.events;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventType;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.service.DemoBotService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

@Component
@RequiredArgsConstructor
public class DelMarkupEventType implements EventType {
    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.DEL_MARKUP;
    }

    @Override
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {
        demoBotService.execute(SendMessage.builder()
                .text("Delete reply markup")
                .chatId(customEvent.getMessage().getChatId())
                .replyMarkup(ReplyKeyboardRemove.builder()
                        .removeKeyboard(true)
                        .build())
                .build());
        demoBotService.execute(DeleteMessage.builder()
                .messageId(customEvent.getMessage().getMessageId())
                .chatId(customEvent.getMessage().getChatId())
                .build());
    }
}
