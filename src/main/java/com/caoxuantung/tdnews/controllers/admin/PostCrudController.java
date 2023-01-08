package com.caoxuantung.tdnews.controllers.admin;

import com.caoxuantung.tdnews.models.Category;
import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.CategoryRepository;
import com.caoxuantung.tdnews.repositories.PostRepository;
import com.caoxuantung.tdnews.repositories.TagRepository;
import com.caoxuantung.tdnews.repositories.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "admin/post/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("mode", "store");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tagList", tagRepository.findAll());
        return "admin/post/create";
    }

    @PostMapping("store")
    public String store(@ModelAttribute("post") Post post, RedirectAttributes model) {
        User author = userRepository.findByEmail("alex.cao@gmail.com");
        post.setAuthor(author);
        postRepository.save(post);
//        System.out.println(post.getTags());
        return "redirect:/admin/post";
    }

    @PostMapping("update")
    public String update(@ModelAttribute("post") Post post, RedirectAttributes model) {
        Optional<Post> optionalPost = postRepository.findById(post.getId());
        if (optionalPost.isPresent()) {
            Post updatePost = optionalPost.get();
            updatePost.setTitle(post.getTitle());
            updatePost.setDocument(post.getDocument());
            updatePost.setTags(post.getTags());
            updatePost.setCategory(post.getCategory());
            postRepository.save(updatePost);
        } else {
            return "redirect:/admin/post";
        }
        return "redirect:/admin/post";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            model.addAttribute("mode", "update");
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("tagList", tagRepository.findAll());
        } else {
            return "redirect:/admin/post";
        }
        return "admin/post/create";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            postRepository.delete(post);
        }
        return "redirect:/admin/post";
    }
}
