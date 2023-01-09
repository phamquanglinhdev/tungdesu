package com.caoxuantung.tdnews.controllers;

import com.caoxuantung.tdnews.repositories.UserRepository;
import com.caoxuantung.tdnews.services.CategoryServices;
import com.caoxuantung.tdnews.services.PostServices;
import com.caoxuantung.tdnews.services.TagServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    PostServices postServices;
    @Autowired
    CategoryServices categoryServices;

    @Autowired
    TagServices tagServices;

    @GetMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("newestPost", postServices.getNewestPost());
        model.addAttribute("trendingPost", postServices.getTrendingPost());
        model.addAttribute("recentPost", postServices.getRecentPost());
        model.addAttribute("categories", categoryServices.getAll());
        model.addAttribute("tags", tagServices.getAll());
        return "index";
    }

    @GetMapping(value = {"login"})
    public String login() {
        return "login";
    }

    @GetMapping(value = {"register"})
    public String register() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
}
