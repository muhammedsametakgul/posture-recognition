package com.sametakgul.posture_recognition_receiver_service.repository;

import com.sametakgul.posture_recognition_receiver_service.entity.model.Posture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostureRepository  extends JpaRepository<Posture, Long> {
}
