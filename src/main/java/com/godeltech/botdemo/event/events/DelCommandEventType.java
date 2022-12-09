package com.godeltech.botdemo.event.events;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventType;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.service.DemoBotService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.commands.DeleteMyCommands;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeChat;

@Component
@RequiredArgsConstructor
public class DelCommandEventType implements EventType {
    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.DEL_COMMAND;
    }

    @Override
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {
        demoBotService.execute(DeleteMyCommands.builder()
                .languageCode(null)
                .scope(new BotCommandScopeChat(customEvent.getMessage().getChatId().toString()))
                .build());
        demoBotService.execute(DeleteMessage.builder()
                .chatId(customEvent.getMessage().getChatId())
                .messageId(customEvent.getMessage().getMessageId())
                .build());
    }
}
