package com.godeltech.botdemo.resolver;

import com.godeltech.botdemo.resolver.callback.CallbackType;
import com.godeltech.botdemo.resolver.callback.impl.NotFoundCallbackType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CallbackResolver {
    private final Map<String, CallbackType> callbackContext;

    @Autowired
    public CallbackResolver(List<CallbackType> callbackTypes) {
        this.callbackContext = callbackTypes.stream()
                .collect(Collectors.toMap(CallbackType::getCallbackName, Function.identity()));
    }

    public BotApiMethod getBotMethod(CallbackQuery callbackQuery) {
        return callbackContext.getOrDefault(callbackQuery.getData(), (CallbackType) new NotFoundCallbackType())
                .createMethod(callbackQuery);
    }
}
