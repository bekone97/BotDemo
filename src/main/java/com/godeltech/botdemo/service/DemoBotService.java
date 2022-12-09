package com.godeltech.botdemo.service;

import com.godeltech.botdemo.props.BotProp;
import com.godeltech.botdemo.resolver.CallbackResolver;
import com.godeltech.botdemo.resolver.InlineQueryResolver;
import com.godeltech.botdemo.resolver.MessageEntityResolver;
import com.godeltech.botdemo.resolver.MessageResolver;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerPreCheckoutQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.payments.PreCheckoutQuery;

@Component
@Slf4j
@RequiredArgsConstructor
public class DemoBotService extends TelegramLongPollingBot {

    private final BotProp botProp;
    private final CallbackResolver callbackResolver;
    private final MessageEntityResolver messageEntityResolver;
    private final MessageResolver messageResolver;
    private final InlineQueryResolver inlineQueryResolver;

    @Override
    public String getBotUsername() {
        return botProp.getName();
    }

    @Override
    public String getBotToken() {
        return botProp.getToken();
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasPreCheckoutQuery()){
            PreCheckoutQuery preCheckoutQuery = update.getPreCheckoutQuery();
            execute(AnswerPreCheckoutQuery.builder()
                    .ok(true)
                    .errorMessage(null)
                    .preCheckoutQueryId(preCheckoutQuery.getId())
                    .build());
        }else if (update.hasInlineQuery()){
            execute(inlineQueryResolver.handleQuery(update.getInlineQuery()));
        }else if (update.hasCallbackQuery()) {
            execute(callbackResolver.getBotMethod(update.getCallbackQuery()));
        } else if (update.hasMessage() && update.getMessage().hasEntities()) {
           execute(messageEntityResolver.getBotMethod(update.getMessage()));
        } else {
           execute(messageResolver.getBotMethod(update.getMessage()));
        }
    }
}
