package com.caoxuantung.tdnews.untils;

import com.caoxuantung.tdnews.dto.UserDto;
import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Self {
    @Autowired
    private UserRepository userRepository;

    public UserDto get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email);
        return new UserDto(user.getEmail(), user.getName(), user.getRole());
    }
}
