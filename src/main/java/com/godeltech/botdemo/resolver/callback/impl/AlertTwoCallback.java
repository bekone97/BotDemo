package com.godeltech.botdemo.resolver.callback.impl;

import com.godeltech.botdemo.Callbacks;
import com.godeltech.botdemo.resolver.callback.CallbackType;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class AlertTwoCallback implements CallbackType {
    @Override
    public String getCallbackName() {
        return Callbacks.ALERT_TWO.name();
    }

    @Override
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        return AnswerCallbackQuery.builder()
                .cacheTime(10)
                .text("Alert type 2")
                .showAlert(true)
                .callbackQueryId(callbackQuery.getId())
                .build();
    }
}
