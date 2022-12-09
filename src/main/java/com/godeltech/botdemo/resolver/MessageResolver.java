package com.godeltech.botdemo.resolver;

import com.godeltech.botdemo.resolver.message.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
public class MessageResolver {

    private final MessageType messageType;

    public BotApiMethod getBotMethod(Message message) {
        throw new RuntimeException();
    }
}
