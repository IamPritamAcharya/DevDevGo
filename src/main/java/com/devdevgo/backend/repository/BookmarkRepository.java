package com.devdevgo.backend.repository;

import com.devdevgo.backend.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    List<Bookmark> findByUser_Id(Long userId);

    boolean existsByUser_IdAndContent_Id(Long userId, Long contentId);
}