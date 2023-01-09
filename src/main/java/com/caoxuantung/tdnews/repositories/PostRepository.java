package com.caoxuantung.tdnews.repositories;

import com.caoxuantung.tdnews.models.Category;
import com.caoxuantung.tdnews.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findTop6ByOrderByCreatedDesc();

    List<Post> findTop3ByOrderByCommentsDesc();

    List<Post> findTop3ByOrderByUpdatedDesc();

    List<Post> findByCategoryIdOrderByCreatedDesc(Long categoryId);
    List<Post> findByTagsIdOrderByCreatedDesc(Long tagId);
}