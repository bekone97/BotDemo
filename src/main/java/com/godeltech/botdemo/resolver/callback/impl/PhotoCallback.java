package com.godeltech.botdemo.resolver.callback.impl;

import com.godeltech.botdemo.Callbacks;
import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.resolver.callback.CallbackType;
import com.godeltech.botdemo.utils.BotUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

@Component
@RequiredArgsConstructor
public class PhotoCallback implements CallbackType {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String getCallbackName() {
        return Callbacks.PHOTO.name();
    }

    @Override
    @SneakyThrows
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        applicationEventPublisher.publishEvent(CustomEvent.builder()
                .type(Type.PHOTO)
                .message(callbackQuery.getMessage())
                .build());
        return BotUtil.getMainSendMessage(callbackQuery.getMessage(),"Photo was sent");
    }
}
