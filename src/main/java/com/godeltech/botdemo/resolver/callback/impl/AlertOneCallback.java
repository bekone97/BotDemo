package com.godeltech.botdemo.resolver.callback.impl;

import com.godeltech.botdemo.Callbacks;
import com.godeltech.botdemo.resolver.callback.CallbackType;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
public class AlertOneCallback implements CallbackType {
    @Override
    public String getCallbackName() {
        return Callbacks.ALERT_ONE.name();
    }

    @Override
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        return  AnswerCallbackQuery.builder()
                .cacheTime(10)
                .text("Alert type 1")
                .showAlert(false)
                .callbackQueryId(callbackQuery.getId())
                .build();
    }
}
