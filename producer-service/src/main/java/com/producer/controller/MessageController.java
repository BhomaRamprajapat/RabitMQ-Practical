package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/message")
public class MessageController
{
    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/send")
    public String sendMessage(@RequestBody String text) {

        boolean sent = streamBridge.send("sendMessage-out-0", text);

        return sent ? "Sent via StreamBridge" : "Failed to send";
    }
}
