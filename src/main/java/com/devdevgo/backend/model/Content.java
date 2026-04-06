package com.devdevgo.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String summary;

    @Enumerated(EnumType.STRING)
    private ContentType type;

    // for snippet
    @Column(length = 5000)
    private String code;

    private String language;

    // for article
    private String imageUrl;

    private String difficulty;

    private LocalDateTime createdAt = LocalDateTime.now();
}