package com.caoxuantung.tdnews.seed;

import com.caoxuantung.tdnews.repositories.CategoryRepository;
import com.caoxuantung.tdnews.repositories.PostRepository;
import com.caoxuantung.tdnews.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataSeeder implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        UserSeeder userSeeder = new UserSeeder(passwordEncoder, userRepository);
        userSeeder.run();
        new CategorySeeder(categoryRepository).run();
        new PostSeeder(postRepository, userRepository, categoryRepository).run();
    }

}
