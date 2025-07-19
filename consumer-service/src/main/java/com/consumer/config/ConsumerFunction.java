package com.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumerFunction
{

    @Bean
    public Consumer<String> receiveMessage()
    {
        return msg -> log.info("Received message: {}", msg);

        // this is event listener where we can trigger email whatsapp notification or whatever we want
    }
}
