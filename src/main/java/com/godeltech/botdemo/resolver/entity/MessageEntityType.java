package com.godeltech.botdemo.resolver.entity;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageEntityType {
    String getEntityName();

    BotApiMethod createMethod(Message message);
}
