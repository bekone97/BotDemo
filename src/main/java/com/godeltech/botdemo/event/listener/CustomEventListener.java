package com.godeltech.botdemo.event.listener;

import com.godeltech.botdemo.event.CustomEvent;
import com.godeltech.botdemo.event.EventResolver;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomEventListener {

    private final EventResolver eventResolver;

    @EventListener
    @SneakyThrows
    public void handleEvent(CustomEvent customEvent) {
        log.info("Get custom event : {} ", customEvent);
        eventResolver.handleEvent(customEvent);
    }
}
