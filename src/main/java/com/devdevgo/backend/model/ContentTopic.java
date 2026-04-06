package com.devdevgo.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "content_topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}