package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.Topic;
import com.devdevgo.backend.model.UserTopic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

}