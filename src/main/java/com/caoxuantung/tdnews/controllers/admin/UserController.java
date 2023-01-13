package com.caoxuantung.tdnews.controllers.admin;

import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.UserRepository;
import com.caoxuantung.tdnews.untils.Self;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Self self;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("profile")
    public String profile(Model model) {
        model.addAttribute("user", self.get());
        return "profile";
    }

    @PostMapping("update")
    public String update(
            @RequestParam(name = "avatar") String avatar,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email,
            RedirectAttributes model
    ) {
        User user = userRepository.findByEmail(self.get().getEmail());
        if (user != null) {
            user.setAvatar(avatar);
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
            model.addFlashAttribute("notify", "Successfully");
        }
        return "redirect:/user/profile";
    }

    @PostMapping("change-password")
    public String changePassword(
            RedirectAttributes model,
            @RequestParam(name = "old_password") String oldPassword,
            @RequestParam(name = "new_password") String newPassword,
            @RequestParam(name = "re_password") String rePassword
    ) {
        System.out.println(oldPassword);
        User user = userRepository.findByEmail(self.get().getEmail());
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            model.addFlashAttribute("passError", "Old password not match !");
            return "redirect:/user/profile";
        }
        if (!Objects.equals(newPassword, rePassword)) {
            model.addFlashAttribute("passError", "Re password not match !");
            return "redirect:/user/profile";
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        model.addFlashAttribute("passNotify", "Change successfully");
        return "redirect:/user/profile";
    }
}
