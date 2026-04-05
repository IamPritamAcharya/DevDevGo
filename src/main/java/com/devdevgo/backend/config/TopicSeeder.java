package com.devdevgo.backend.config;

import com.devdevgo.backend.model.Topic;
import com.devdevgo.backend.repository.TopicRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TopicSeeder {

    private final TopicRepository topicRepository;

    @PostConstruct
    public void seedTopics() {

        if (topicRepository.count() > 0)
            return;

        List<Topic> topics = List.of(
                Topic.builder().name("Spring Boot").slug("spring-boot").description("Backend development with Spring")
                        .build(),
                Topic.builder().name("Java").slug("java").description("Core Java concepts").build(),
                Topic.builder().name("Flutter").slug("flutter").description("Cross-platform UI development").build(),
                Topic.builder().name("System Design").slug("system-design").description("Architecture and scalability")
                        .build(),
                Topic.builder().name("DSA").slug("dsa").description("Data structures and algorithms").build(),
                Topic.builder().name("Backend Development").slug("backend").description("APIs and servers").build(),
                Topic.builder().name("DevOps").slug("devops").description("CI/CD and deployment").build(),
                Topic.builder().name("Git").slug("git").description("Version control system").build(),
                Topic.builder().name("Databases").slug("databases").description("SQL and NoSQL databases").build(),
                Topic.builder().name("JavaScript").slug("javascript").description("Frontend & backend JS").build(),
                Topic.builder().name("Python").slug("python").description("General purpose programming").build(),
                Topic.builder().name("Go").slug("go").description("High performance backend language").build(),
                Topic.builder().name("AI Tools").slug("ai-tools").description("AI tools for developers").build(),
                Topic.builder().name("Cloud").slug("cloud").description("AWS, GCP, Azure").build(),
                Topic.builder().name("Linux").slug("linux").description("OS and commands").build(),
                Topic.builder().name("Open Source").slug("open-source").description("Community projects").build());

        topicRepository.saveAll(topics);
    }
}