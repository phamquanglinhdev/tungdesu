package com.caoxuantung.tdnews.controllers.admin;

import com.caoxuantung.tdnews.models.Category;
import com.caoxuantung.tdnews.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("admin/category")
public class CategoryCrudController {
    private final CategoryRepository categoryRepository;

    public CategoryCrudController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "admin/category/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("mode", "store");
        return "admin/category/create";
    }

    @GetMapping("edit/{id}")
    public String create(@PathVariable Long id, Model model) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category updateCategory = optionalCategory.get();
            model.addAttribute("category", updateCategory);
            model.addAttribute("mode", "update");
        }
        return "admin/category/create";
    }

    @PostMapping("store")
    public String create(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
        if (optionalCategory.isPresent()) {
            Category updateCategory = optionalCategory.get();
            updateCategory.setName(category.getName());
            categoryRepository.save(updateCategory);
        }
        return "redirect:/admin/category";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            categoryRepository.delete(category);
        }
        return "redirect:/admin/category";
    }
}