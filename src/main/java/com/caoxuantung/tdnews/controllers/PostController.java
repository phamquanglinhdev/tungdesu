package com.caoxuantung.tdnews.controllers;

import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.repositories.PostRepository;
import com.caoxuantung.tdnews.services.CategoryServices;
import com.caoxuantung.tdnews.services.PostServices;
import com.caoxuantung.tdnews.services.TagServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    PostServices postServices;
    @Autowired
    CategoryServices categoryServices;
    @Autowired
    TagServices tagServices;

    @GetMapping("post/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postRepository.getReferenceById(id);
        model.addAttribute("post", post);
        model.addAttribute("recentPost", postServices.getRecentPost());
        model.addAttribute("categories", categoryServices.getAll());
        model.addAttribute("tags", tagServices.getAll());
        return "product";
    }

}
