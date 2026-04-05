package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}