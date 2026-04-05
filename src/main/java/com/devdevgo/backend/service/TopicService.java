package com.devdevgo.backend.service;

import com.devdevgo.backend.dto.TopicResponse;
import com.devdevgo.backend.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<TopicResponse> getAllTopics() {
        return topicRepository.findAll()
                .stream()
                .map(topic -> TopicResponse.builder()
                        .id(topic.getId())
                        .name(topic.getName())
                        .slug(topic.getSlug())
                        .build())
                .toList();
    }
}