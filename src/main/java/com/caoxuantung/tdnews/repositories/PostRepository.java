package com.caoxuantung.tdnews.repositories;

import com.caoxuantung.tdnews.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}