package com.godeltech.botdemo.resolver.message.impl;

import com.godeltech.botdemo.resolver.message.MessageType;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class MessageTypeImpl implements MessageType {

    @Override
    public BotApiMethod createMethod(Message message) {
        return SendMessage.builder()
                .text("Sorry can you choose some option")
                .chatId(message.getChatId().toString())
                .build();
    }
}
