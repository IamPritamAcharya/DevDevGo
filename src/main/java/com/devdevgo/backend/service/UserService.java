package com.devdevgo.backend.service;

import com.devdevgo.backend.dto.TopicResponse;
import com.devdevgo.backend.dto.UserProfileResponse;
import com.devdevgo.backend.dto.UserResponse;
import com.devdevgo.backend.dto.UserSignupRequest;
import com.devdevgo.backend.model.*;
import com.devdevgo.backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final UserTopicRepository userTopicRepository;

    public UserResponse signup(UserSignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        List<Topic> topics = topicRepository.findAllById(request.getTopicIds());

        List<UserTopic> mappings = topics.stream()
                .map(topic -> UserTopic.builder()
                        .user(savedUser)
                        .topic(topic)
                        .build())
                .toList();

        userTopicRepository.saveAll(mappings);

        return UserResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .build();
    }

    public UserProfileResponse getUserProfile(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<UserTopic> userTopics = userTopicRepository.findByUser_Id(userId);

        List<TopicResponse> topics = userTopics.stream()
                .map(ut -> TopicResponse.builder()
                        .id(ut.getTopic().getId())
                        .name(ut.getTopic().getName())
                        .slug(ut.getTopic().getSlug())
                        .build())
                .toList();

        return UserProfileResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .topics(topics)
                .build();
    }
}