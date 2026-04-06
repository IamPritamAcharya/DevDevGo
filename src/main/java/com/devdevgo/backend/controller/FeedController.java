package com.devdevgo.backend.controller;

import com.devdevgo.backend.dto.FeedResponse;
import com.devdevgo.backend.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @GetMapping("/{userId}")
    public List<FeedResponse> getFeed(@PathVariable Long userId) {
        return feedService.getFeed(userId);
    }
}