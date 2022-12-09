package com.godeltech.botdemo.event.events;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventType;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.service.DemoBotService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

@Component
@RequiredArgsConstructor
public class AudioEventType implements EventType {

    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.AUDIO;
    }

    @Override
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {
        File song = ResourceUtils.getFile("classpath:" + "UveziteMenyaNaDeepHouse.mp3");
        demoBotService.execute(DeleteMessage.builder()
                .messageId(customEvent.getMessage().getMessageId())
                .chatId(customEvent.getMessage().getChatId())
                .build());
        demoBotService.execute(SendAudio.builder()
                .chatId(customEvent.getMessage().getChatId())
                .audio(new InputFile(song))
                .build());
    }
}
