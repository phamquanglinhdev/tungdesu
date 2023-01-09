package com.caoxuantung.tdnews.repositories;

import com.caoxuantung.tdnews.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();
}