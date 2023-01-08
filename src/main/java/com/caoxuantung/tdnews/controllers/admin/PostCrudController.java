package com.caoxuantung.tdnews.controllers.admin;

import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.PostRepository;
import com.caoxuantung.tdnews.repositories.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("admin/post")
public class PostCrudController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "admin/post/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "admin/post/create";
    }

    @PostMapping("store")
    public String store(@ModelAttribute("post") Post post, RedirectAttributes model) {
        User author = userRepository.findByEmail("alex.cao@gmail.com");
        post.setAuthor(author);
        postRepository.save(post);
        return "redirect:/admin/post";
    }
}
