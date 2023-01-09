package com.caoxuantung.tdnews.services;

import com.caoxuantung.tdnews.models.Category;
import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.repositories.CategoryRepository;
import com.caoxuantung.tdnews.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PostRepository postRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.getReferenceById(id);
    }

    public List<Post> getPosts(Long id) {
        Category category = categoryRepository.getReferenceById(id);
        return postRepository.findByCategoryIdOrderByCreatedDesc(id);
    }
}
