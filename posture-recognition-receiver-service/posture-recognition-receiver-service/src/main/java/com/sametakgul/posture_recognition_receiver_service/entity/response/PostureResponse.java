package com.sametakgul.posture_recognition_receiver_service.entity.response;

import com.sametakgul.posture_recognition_receiver_service.entity.model.Posture;

import java.util.List;

public class PostureResponse {
    private List<Posture> goodPostures;
    private List<Posture> badPostures;

    public PostureResponse(List<Posture> goodPostures, List<Posture> badPostures) {
        this.goodPostures = goodPostures;
        this.badPostures = badPostures;
    }

    public List<Posture> getGoodPostures() {
        return goodPostures;
    }

    public void setGoodPostures(List<Posture> goodPostures) {
        this.goodPostures = goodPostures;
    }

    public List<Posture> getBadPostures() {
        return badPostures;
    }

    public void setBadPostures(List<Posture> badPostures) {
        this.badPostures = badPostures;
    }
}
