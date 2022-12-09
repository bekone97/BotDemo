package com.godeltech.botdemo.resolver.callback;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public interface CallbackType {
    String getCallbackName();

    BotApiMethod createMethod(CallbackQuery callbackQuery);
}
