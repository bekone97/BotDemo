package com.godeltech.botdemo.resolver.callback.impl;

import com.godeltech.botdemo.Callbacks;
import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.resolver.callback.CallbackType;
import com.godeltech.botdemo.utils.BotUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

@Component
@RequiredArgsConstructor
public class DelMarkupCallback implements CallbackType {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String getCallbackName() {
        return Callbacks.DEL_MARKUP.name();
    }

    @Override
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        applicationEventPublisher.publishEvent(CustomEvent.builder()
                .message(callbackQuery.getMessage())
                .type(Type.DEL_MARKUP)
                .build());
        return BotUtil.getMainSendMessage(callbackQuery.getMessage(),"Reply markup was deleted");
    }
}
