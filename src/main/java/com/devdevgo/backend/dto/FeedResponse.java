package com.devdevgo.backend.dto;

import com.devdevgo.backend.model.ContentType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FeedResponse {

    private Long id;
    private String title;
    private String summary;
    private ContentType type;

    private String code;
    private String language;

    private String imageUrl;
    private String difficulty;
}