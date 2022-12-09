package com.godeltech.botdemo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class BotHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public void handleRuntimeException(RuntimeException exception) {
        log.error(exception.getMessage());
    }
}
