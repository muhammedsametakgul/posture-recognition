package com.sametakgul.posture_recognition_receiver_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sametakgul.posture_recognition_receiver_service.entity.model.Posture;
import com.sametakgul.posture_recognition_receiver_service.repository.PostureRepository;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostureService {

    private static final Logger logger = LoggerFactory.getLogger(PostureService.class);
    private final PostureRepository postureDataRepository;
    private final ObjectMapper objectMapper;

    public PostureService(PostureRepository postureDataRepository, ObjectMapper objectMapper) {
        this.postureDataRepository = postureDataRepository;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "posture_queue")
    public void receiveMessage(String message) {
        try {
            Posture postureData = objectMapper.readValue(message, Posture.class);
            postureDataRepository.save(postureData);
            logger.info("Data saved successfully: {}", postureData);
        } catch (Exception e) {
            logger.error("Failed to save posture data: {}", e.getMessage());
        }
    }

    public List<Posture> getGoodPostures() {
        return postureDataRepository.findAll().stream()
                .filter(posture -> "İyi Postür".equals(posture.getPosture()))
                .collect(Collectors.toList());
    }

    public List<Posture> getBadPostures() {
        return postureDataRepository.findAll().stream()
                .filter(posture -> "Kötü Postür".equals(posture.getPosture()))
                .collect(Collectors.toList());
    }
}
