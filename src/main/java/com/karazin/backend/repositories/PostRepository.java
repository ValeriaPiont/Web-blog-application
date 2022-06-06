package com.karazin.backend.repositories;

import com.karazin.backend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserIdOrderByCreatedOnDesc(Long userId);

    @Query(value = "SELECT * FROM posts ORDER BY created_on DESC", nativeQuery = true)
    List<Post> findAll();

}
