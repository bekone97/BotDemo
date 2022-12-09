package com.godeltech.botdemo.event.events;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventType;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.service.DemoBotService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeChat;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SetCommandEventType implements EventType {
    private final DemoBotService demoBotService ;
    @Override
    public Type getEventType() {
        return Type.SET_COMMAND;
    }

    @SneakyThrows
    @Override
    public void handleEvent(CustomEvent customEvent) {
        demoBotService.execute(SetMyCommands.builder()
                        .commands(getCommands())
                        .scope(new BotCommandScopeChat(customEvent.getMessage().getChatId().toString()))
                .build());
        demoBotService.execute(DeleteMessage.builder()
                        .messageId(customEvent.getMessage().getMessageId())
                        .chatId(customEvent.getMessage().getChatId())
                .build());
    }

    private List<BotCommand> getCommands(){
        return List.of(BotCommand.builder()
                        .command("/start")
                        .description("Get main options of bot")
                        .build(),
                BotCommand.builder()
                        .command("/info")
                        .description("What is this bot about")
                        .build());
    }
}
