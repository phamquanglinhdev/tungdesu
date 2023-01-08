package com.caoxuantung.tdnews.repositories;

import com.caoxuantung.tdnews.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}