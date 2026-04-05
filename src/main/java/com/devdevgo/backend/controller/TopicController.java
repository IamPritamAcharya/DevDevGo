package com.devdevgo.backend.controller;

import com.devdevgo.backend.dto.TopicResponse;
import com.devdevgo.backend.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public List<TopicResponse> getTopics() {
        return topicService.getAllTopics();
    }
}