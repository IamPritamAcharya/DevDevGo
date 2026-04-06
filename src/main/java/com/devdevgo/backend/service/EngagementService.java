package com.devdevgo.backend.service;

import com.devdevgo.backend.model.*;
import com.devdevgo.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EngagementService {

    private final BookmarkRepository bookmarkRepository;
    private final ContentLikeRepository likeRepository;
    private final UserRepository userRepository;
    private final ContentRepository contentRepository;

    public String bookmark(Long userId, Long contentId) {

        if (bookmarkRepository.existsByUser_IdAndContent_Id(userId, contentId)) {
            return "Already bookmarked";
        }

        User user = userRepository.findById(userId).orElseThrow();
        Content content = contentRepository.findById(contentId).orElseThrow();

        Bookmark bookmark = Bookmark.builder()
                .user(user)
                .content(content)
                .build();

        bookmarkRepository.save(bookmark);

        return "Bookmarked";
    }

    public String like(Long userId, Long contentId) {

        if (likeRepository.existsByUser_IdAndContent_Id(userId, contentId)) {
            return "Already liked";
        }

        User user = userRepository.findById(userId).orElseThrow();
        Content content = contentRepository.findById(contentId).orElseThrow();

        ContentLike like = ContentLike.builder()
                .user(user)
                .content(content)
                .build();

        likeRepository.save(like);

        return "Liked";
    }
}