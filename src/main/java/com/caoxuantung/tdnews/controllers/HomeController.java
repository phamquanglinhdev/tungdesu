package com.caoxuantung.tdnews.controllers;

import com.caoxuantung.tdnews.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"", "index"})
    public String index() {
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
}
