package com.godeltech.botdemo.resolver.entity.impl;

import com.godeltech.botdemo.Entity;
import com.godeltech.botdemo.resolver.entity.MessageEntityType;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class InfoMessageEntity implements MessageEntityType {
    @Override
    public String getEntityName() {
        return Entity.INFO.getCommand();
    }

    @Override
    public BotApiMethod createMethod(Message message) {
        return null;
    }
}
