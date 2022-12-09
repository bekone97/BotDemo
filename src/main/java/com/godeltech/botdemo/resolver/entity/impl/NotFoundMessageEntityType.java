package com.godeltech.botdemo.resolver.entity.impl;

import com.godeltech.botdemo.resolver.entity.MessageEntityType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public class NotFoundMessageEntityType implements MessageEntityType {
    @Override
    public String getEntityName() {
        return null;
    }

    @Override
    public BotApiMethod createMethod(Message message) {
        throw new RuntimeException("There is no such entity type");
    }
}
