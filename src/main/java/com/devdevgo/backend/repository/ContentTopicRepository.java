package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.ContentTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentTopicRepository extends JpaRepository<ContentTopic, Long> {

    List<ContentTopic> findByTopic_Id(Long topicId);

}