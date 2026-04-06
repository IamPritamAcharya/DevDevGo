package com.devdevgo.backend.config;

import com.devdevgo.backend.model.*;
import com.devdevgo.backend.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContentSeeder {

    private final ContentRepository contentRepository;
    private final TopicRepository topicRepository;
    private final ContentTopicRepository contentTopicRepository;

    @PostConstruct
    public void seed() {

        if (contentRepository.count() > 0)
            return;

        Topic spring = topicRepository.findAll().stream()
                .filter(t -> t.getSlug().equals("spring-boot"))
                .findFirst().orElse(null);

        Topic java = topicRepository.findAll().stream()
                .filter(t -> t.getSlug().equals("java"))
                .findFirst().orElse(null);

        Topic flutter = topicRepository.findAll().stream()
                .filter(t -> t.getSlug().equals("flutter"))
                .findFirst().orElse(null);

        Content c1 = Content.builder()
                .title("What is Dependency Injection?")
                .summary("DI helps reduce tight coupling in applications...")
                .type(ContentType.ARTICLE)
                .imageUrl("https://example.com/image1.jpg")
                .difficulty("beginner")
                .build();

        Content c2 = Content.builder()
                .title("Java Streams Example")
                .summary("Simple example of filtering a list using streams")
                .type(ContentType.SNIPPET)
                .code("list.stream().filter(x -> x > 5).toList();")
                .language("java")
                .build();

        Content c3 = Content.builder()
                .title("Flutter FutureBuilder Example")
                .summary("How to use FutureBuilder in Flutter")
                .type(ContentType.SNIPPET)
                .code("FutureBuilder(future: fetchData(), builder: ...)")
                .language("dart")
                .build();

        contentRepository.saveAll(List.of(c1, c2, c3));

        contentTopicRepository.saveAll(List.of(
                ContentTopic.builder().content(c1).topic(spring).build(),
                ContentTopic.builder().content(c2).topic(java).build(),
                ContentTopic.builder().content(c3).topic(flutter).build()));
    }
}