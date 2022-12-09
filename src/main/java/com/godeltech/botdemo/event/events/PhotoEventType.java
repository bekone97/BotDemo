package com.godeltech.botdemo.event.events;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventType;
import com.godeltech.botdemo.event.Type;
import com.godeltech.botdemo.service.DemoBotService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

@Component
@RequiredArgsConstructor
public class PhotoEventType implements EventType {

    private final DemoBotService demoBotService;

    @Override
    public Type getEventType() {
        return Type.PHOTO;
    }

    @Override
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {
        File image = ResourceUtils.getFile("classpath:" + "IMG.jpg");
        demoBotService.execute(DeleteMessage.builder()
                .chatId(customEvent.getMessage().getChatId())
                .messageId(customEvent.getMessage().getMessageId())
                .build());
        demoBotService.execute(SendPhoto.builder()
                .chatId(customEvent.getMessage().getChatId().toString())
                .caption("Photo")
                .photo(new InputFile(image))
                .build());
    }
}
