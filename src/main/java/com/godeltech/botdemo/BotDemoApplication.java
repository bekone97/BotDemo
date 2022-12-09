package com.godeltech.botdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BotDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotDemoApplication.class, args);
    }

}
