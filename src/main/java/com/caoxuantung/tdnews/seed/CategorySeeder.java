package com.caoxuantung.tdnews.seed;

import com.caoxuantung.tdnews.models.Category;
import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.CategoryRepository;
import jdk.jfr.Enabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@Enabled
public class CategorySeeder {

    private final CategoryRepository categoryRepository;

    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Bean
    public void run() {
        List<String> categories = Arrays.asList("Movie", "Game", "Social", "Life", "Science", "Technology");
        categories.forEach((category) -> {
            if (categoryRepository.findByName(category) == null) {
                Category item = new Category();
                item.setName(category);
                categoryRepository.save(item);
            }
        });
    }
}
