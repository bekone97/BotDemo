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
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MarkupCallbackType implements CallbackType {

    private final ApplicationEventPublisher applicationEventPublisher;
    @Override
    public String getCallbackName() {
        return Callbacks.MARKUP.name();
    }

    @Override
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        applicationEventPublisher.publishEvent(CustomEvent.builder()
                        .type(Type.MARKUP)
                        .message(callbackQuery.getMessage())
                .build());
        return BotUtil.getMainSendMessage(callbackQuery.getMessage(),"Markup was set");

    }
}
