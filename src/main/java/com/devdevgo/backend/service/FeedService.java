package com.devdevgo.backend.service;

import com.devdevgo.backend.dto.FeedResponse;
import com.devdevgo.backend.model.Content;
import com.devdevgo.backend.model.UserTopic;
import com.devdevgo.backend.repository.ContentRepository;
import com.devdevgo.backend.repository.UserTopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeedService {

    private final UserTopicRepository userTopicRepository;
    private final ContentRepository contentRepository;

    public List<FeedResponse> getFeed(Long userId) {

        List<UserTopic> userTopics = userTopicRepository.findByUser_Id(userId);

        List<Long> topicIds = userTopics.stream()
                .map(ut -> ut.getTopic().getId())
                .toList();

        if (topicIds.isEmpty()) {
            return List.of();
        }

        List<Content> contents = contentRepository.findByTopicIds(topicIds);

        Collections.shuffle(contents);

        int limit = Math.min(contents.size(), 20);
        contents = contents.subList(0, limit);

        return contents.stream()
                .map(c -> FeedResponse.builder()
                        .id(c.getId())
                        .title(c.getTitle())
                        .summary(c.getSummary())
                        .type(c.getType())
                        .code(c.getCode())
                        .language(c.getLanguage())
                        .imageUrl(c.getImageUrl())
                        .difficulty(c.getDifficulty())
                        .build())
                .toList();
    }
}