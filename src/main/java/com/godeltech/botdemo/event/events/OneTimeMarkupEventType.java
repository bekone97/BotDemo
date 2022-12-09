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
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButtonPollType;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Component
@RequiredArgsConstructor
public class OneTimeMarkupEventType implements EventType {
    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.ONE_TIME_MARKUP;
    }

    @Override
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {
        demoBotService.execute(SendMessage.builder()
                .text("This action added one time reply markup")
                .chatId(customEvent.getMessage().getChatId())
                .replyMarkup(
                        ReplyKeyboardMarkup.builder()
                                .oneTimeKeyboard(true)
                                .resizeKeyboard(true)
                                .keyboardRow(getFirstKeyboardRow())
                                .keyboardRow(getSecondKeyboardRow())
                                .build()
                )
                .build());
        demoBotService.execute(DeleteMessage.builder()
                .chatId(customEvent.getMessage().getChatId())
                .messageId(customEvent.getMessage().getMessageId())
                .build());
    }

    private KeyboardRow getSecondKeyboardRow() {
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(KeyboardButton.builder()
                .text("Contact")
                .requestContact(true)

                .build());
        keyboardRow.add(KeyboardButton.builder()
                .text("Location")
                .requestLocation(true)
                .build());

        keyboardRow.add(KeyboardButton.builder()
                .text("Poll")
                .requestPoll(new KeyboardButtonPollType())
                .build());
        return keyboardRow;
    }

    private KeyboardRow getFirstKeyboardRow() {
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("Text 1");
        keyboardRow.add("Text 2");
        return keyboardRow;
    }
}
