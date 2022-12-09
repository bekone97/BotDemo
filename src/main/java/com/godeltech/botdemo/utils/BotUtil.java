package com.godeltech.botdemo.utils;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class BotUtil {
    public static SendMessage getMainSendMessage(Message message, String textMessage) {
        return SendMessage.builder()
                .text(textMessage)
                .chatId(message.getChatId().toString())
                .replyMarkup(InlineKeyboardMarkup.builder()
                        .keyboard(List.of(List.of(InlineKeyboardButton.builder()
                                        .text("Set commands")
                                        .callbackData("SET_COMMAND")
                                        .build(), InlineKeyboardButton.builder()
                                        .text("Delete commands")
                                        .callbackData("DEL_COMMAND")
                                        .build()),
                                List.of(InlineKeyboardButton.builder()
                                        .text("External url")
                                        .url("www.google.com")
                                        .build(), InlineKeyboardButton.builder()
                                        .text("Internal url")
                                        .url("https://t.me/BotFather")
                                        .build()),
                                List.of(InlineKeyboardButton.builder()                                        .text("Inline query")
                                        .switchInlineQueryCurrentChat("my inline")
                                        .build()),
                                List.of(InlineKeyboardButton.builder()
                                                .text("Markup Set")
                                                .callbackData("MARKUP")
                                                .build(),
                                        InlineKeyboardButton.builder()
                                                .text("One time markup")
                                                .callbackData("ONE_TIME_MARKUP")
                                                .build(),
                                        InlineKeyboardButton.builder()
                                                .text("Markup delete")
                                                .callbackData("DEL_MARKUP")
                                                .build()),
                                List.of(InlineKeyboardButton.builder()
                                                .text("Show alert 1")
                                                .callbackData("ALERT_ONE")
                                                .build(),
                                        InlineKeyboardButton.builder()
                                                .text("Show alert 2")
                                                .callbackData("ALERT_TWO")
                                                .build()),
                                List.of(InlineKeyboardButton.builder()
                                        .text("Message")
                                        .callbackData("MESSAGE")
                                        .build()),
                                List.of(InlineKeyboardButton.builder()
                                        .text("Send photo")
                                        .callbackData("PHOTO")
                                        .build()),
                                List.of(InlineKeyboardButton.builder()
                                        .text("Send sticker")
                                        .callbackData("STICKER")
                                        .build()),
                                List.of(InlineKeyboardButton.builder()
                                        .text("Send audio")
                                        .callbackData("AUDIO")
                                        .build()),
                                List.of(InlineKeyboardButton.builder()
                                        .text("Payment")
                                        .callbackData("PAYMENT")
                                        .build())))
                        .build())
                .build();
    }
}
