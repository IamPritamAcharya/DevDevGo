package com.devdevgo.backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserProfileResponse {

    private Long id;
    private String name;
    private String email;

    private List<TopicResponse> topics;
}