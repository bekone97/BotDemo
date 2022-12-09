package com.godeltech.botdemo.event;

public interface EventType {
    Type getEventType();

    void handleEvent(CustomEvent customEvent);
}
