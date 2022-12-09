package com.godeltech.botdemo.resolver.message;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface MessageType {

    BotApiMethod createMethod(Message message);
}
