package com.caoxuantung.tdnews.controllers;

import com.caoxuantung.tdnews.models.Comment;
import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.repositories.CommentRepository;
import com.caoxuantung.tdnews.repositories.PostRepository;
import com.caoxuantung.tdnews.repositories.UserRepository;
import com.caoxuantung.tdnews.services.CategoryServices;
import com.caoxuantung.tdnews.services.PostServices;
import com.caoxuantung.tdnews.services.TagServices;
import com.caoxuantung.tdnews.untils.Self;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    Self self;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;

    @GetMapping("post/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postRepository.getReferenceById(id);
        model.addAttribute("post", post);
        model.addAttribute("recentPost", postServices.getRecentPost());
        model.addAttribute("categories", categoryServices.getAll());
        model.addAttribute("tags", tagServices.getAll());
        return "post";
    }

    @PostMapping("comment/add")
    public String addComment(
            @RequestParam(name = "post_id") Long postId,
            @RequestParam(name = "message") String message
    ) {
        Post post = postRepository.getReferenceById(postId);
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setMessage(message);
        comment.setUser(userRepository.findByEmail(self.get().getEmail()));
        commentRepository.save(comment);
        return "redirect:/post/" + postId;
    }

}
