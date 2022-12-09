package com.godeltech.botdemo.event.events;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventType;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.service.DemoBotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
@Slf4j
public class StickerEventType implements EventType {

    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.STICKER;
    }

    @Override
    public void handleEvent(CustomEvent customEvent) {
        try {
            demoBotService.execute(SendSticker.builder()
                    .chatId(customEvent.getMessage().getChatId())
                    .sticker(new InputFile("CAACAgIAAxkBAAITP2OIjaO9tJkRMmFOqzxMjasslra8AAIRFAACoAAB6EuHKd82dqZdoSsE"))
                    .build());
            demoBotService.execute(DeleteMessage.builder()
                    .messageId(customEvent.getMessage().getMessageId())
                    .chatId(customEvent.getMessage().getChatId())
                    .build());
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
            log.error(e.getMessage());
            log.error(e.getMessage());
        }
    }
}
