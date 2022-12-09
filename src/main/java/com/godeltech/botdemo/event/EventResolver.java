package com.godeltech.botdemo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class EventResolver {
    private final Map<Type, EventType> eventContext;

    @Autowired
    public EventResolver(List<EventType> eventTypes) {
        this.eventContext = eventTypes.stream()
                .collect(Collectors.toMap(EventType::getEventType, Function.identity()));
    }

    public void handleEvent(CustomEvent customEvent) {
        eventContext.get(customEvent.getType())
                .handleEvent(customEvent);
    }
}
