package com.sametakgul.posture_recognition_message_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class RabbitConfig {


    private static final String QUEUE_NAME = "posture_queue";

    @Bean
    public Queue postureQueue() {
        return new Queue(QUEUE_NAME, true);
    }
}
