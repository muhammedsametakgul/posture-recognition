package com.sametakgul.posture_recognition_receiver_service.controller;

import com.sametakgul.posture_recognition_receiver_service.entity.response.PostureResponse;
import com.sametakgul.posture_recognition_receiver_service.service.PostureService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostureController {

    private final PostureService postureService;

    public PostureController(PostureService postureService) {
        this.postureService = postureService;
    }

    @GetMapping("/api/posture")
    @CrossOrigin
    public PostureResponse getPostures() {
        return new PostureResponse(postureService.getGoodPostures(), postureService.getBadPostures());
    }
}
