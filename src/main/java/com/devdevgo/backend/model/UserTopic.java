package com.devdevgo.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
}