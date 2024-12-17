package com.sametakgul.posture_recognition_message_service.controller;

import com.sametakgul.posture_recognition_message_service.service.MessageQueueService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageQueueController {


    private final MessageQueueService messageQueueService;

    public MessageQueueController(MessageQueueService messageQueueService) {
        this.messageQueueService = messageQueueService;
    }

    @PostMapping("/sendPosture")
    public String receivePostureData(@RequestBody String postureData) {
        messageQueueService.sendToQueue(postureData);
        return "Data sent to message queue";
    }
}
