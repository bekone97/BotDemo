package com.godeltech.botdemo.resolver;

import com.godeltech.botdemo.resolver.entity.MessageEntityType;
import com.godeltech.botdemo.resolver.entity.impl.NotFoundMessageEntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
public class MessageEntityResolver {

    private final Map<String, MessageEntityType> messageEntityContext;

    @Autowired
    public MessageEntityResolver(List<MessageEntityType> messageEntityTypes) {
        this.messageEntityContext = messageEntityTypes.stream()
                .collect(Collectors.toMap(MessageEntityType::getEntityName, Function.identity()));
    }

    public BotApiMethod getBotMethod(Message message) {
        return messageEntityContext.getOrDefault(message.getText(), (MessageEntityType) new NotFoundMessageEntityType())
                .createMethod(message);
    }
}
