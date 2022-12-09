package com.godeltech.botdemo.resolver.callback.impl;

import com.godeltech.botdemo.Callbacks;
import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.resolver.callback.CallbackType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.invoices.SendInvoice;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentCallback implements CallbackType {
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String getCallbackName() {
        return Callbacks.PAYMENT.name();
    }

    @Override
    public BotApiMethod createMethod(CallbackQuery callbackQuery) {
        applicationEventPublisher.publishEvent(CustomEvent.builder()
                .message(callbackQuery.getMessage())
                .type(Type.DELETE)
                .build());
        return SendInvoice.builder()
                .title("Билет")
                .description("Билет на поезд из Беларуси")
                .payload("Билет1")
                .photoUrl("https://cdn2.tu-tu.ru/image/source/2/99c8a5bbea3424eaada78c51f79a8568/")
                .photoHeight(300)
                .photoWidth(300)
                .startParameter("startParam")
                .providerToken("284685063:TEST:YzVmMzgzNmFjNjVl")
                .currency("RUB")
                .needEmail(true)
                .needName(true)
                .needPhoneNumber(true)
                .needShippingAddress(true)
                .maxTipAmount(20000)
                .suggestedTipAmount(10000)
                .price(LabeledPrice.builder().label("Цена").amount(300000).build())
                .price(LabeledPrice.builder().label("Доставка").amount(20000).build())
                .chatId(callbackQuery.getMessage().getChatId())
                .replyMarkup(InlineKeyboardMarkup.builder()
                        .keyboardRow(List.of(InlineKeyboardButton.builder()
                                .text("Buy")
                                .pay(true)
                                .build(), InlineKeyboardButton.builder()
                                .text("Menu")
                                .callbackData("MAIN_MENU")
                                .build()))
                        .build())
                .build();
    }
}
