package com.godeltech.botdemo.resolver.callback.impl;

import com.godeltech.botdemo.resolver.callback.CallbackType;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

public class NotFoundCallbackType implements CallbackType {
    @Override
    public String getCallbackName() {
        return null;
    }

    @Override
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        throw new RuntimeException("Not found callback");
    }
}
