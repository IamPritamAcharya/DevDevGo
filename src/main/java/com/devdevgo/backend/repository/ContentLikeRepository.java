package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.ContentLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentLikeRepository extends JpaRepository<ContentLike, Long> {

    boolean existsByUser_IdAndContent_Id(Long userId, Long contentId);
}