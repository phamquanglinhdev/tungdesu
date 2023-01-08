package com.caoxuantung.tdnews.repositories;

import com.caoxuantung.tdnews.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}