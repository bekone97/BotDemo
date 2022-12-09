package com.godeltech.botdemo.resolver.callback.impl;

import com.godeltech.botdemo.Callbacks;
import com.godeltech.botdemo.resolver.callback.CallbackType;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class VideoCallback implements CallbackType {
    @Override
    public String getCallbackName() {
        return Callbacks.VIDEO.name();
    }

    @Override
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        return null;
    }
}
