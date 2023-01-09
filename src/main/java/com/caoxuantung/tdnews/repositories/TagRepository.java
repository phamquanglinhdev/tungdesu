package com.caoxuantung.tdnews.repositories;

import com.caoxuantung.tdnews.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAll();
}