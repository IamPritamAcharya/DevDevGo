package com.devdevgo.backend.controller;

import com.devdevgo.backend.service.EngagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engagement")
@RequiredArgsConstructor
public class EngagementController {

    private final EngagementService engagementService;

    @PostMapping("/bookmark")
    public String bookmark(@RequestParam Long userId,
            @RequestParam Long contentId) {
        return engagementService.bookmark(userId, contentId);
    }

    @PostMapping("/like")
    public String like(@RequestParam Long userId,
            @RequestParam Long contentId) {
        return engagementService.like(userId, contentId);
    }
}