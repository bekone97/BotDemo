package com.godeltech.botdemo;

import lombok.Getter;

@Getter
public enum Entity {
    START("/start"), INFO("/info");
    private String command;

    Entity(String command) {
        this.command = command;
    }
}
