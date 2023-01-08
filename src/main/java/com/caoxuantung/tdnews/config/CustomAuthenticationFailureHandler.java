package com.caoxuantung.tdnews.config;


import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException, ServletException {
        String error = "notbiet";
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userRepository.findByEmail(email);
        if (user == null) {
            error = "wrong.email";
        } else if (!passwordEncoder.matches(password, user.getPassword())) {
            error = "wrong.password";
        }


        response.sendRedirect("/login?error=" + error);
    }
}