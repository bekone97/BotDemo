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
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MarkupEventType implements EventType {
    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.MARKUP;
    }

    @Override
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {

        demoBotService.execute(SendMessage.builder()
                .text("Set markup")
                .chatId(customEvent.getMessage().getChatId())
                .replyMarkup(ReplyKeyboardMarkup.builder()
//                        .resizeKeyboard(true)
                        .keyboardRow(getKeyboardRow("LabelOne", "LabelTwo"))
                        .keyboardRow(getKeyboardRow("LabelThree", "LabelFour"))
                        .build())
                .build());
        demoBotService.execute(DeleteMessage.builder()
                .messageId(customEvent.getMessage().getMessageId())
                .chatId(customEvent.getMessage().getChatId())
                .build());
    }

    private KeyboardRow getKeyboardRow(String labelOne, String labelTwo) {
        return new KeyboardRow(
                List.of(KeyboardButton.builder()
                                .text(labelOne)
                                .build(),
                        KeyboardButton.builder()
                                .text(labelTwo)
                                .build())
        );
    }
}
