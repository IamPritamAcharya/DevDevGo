package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.UserTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTopicRepository extends JpaRepository<UserTopic, Long> {
}