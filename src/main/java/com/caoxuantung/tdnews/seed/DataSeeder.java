package com.caoxuantung.tdnews.seed;

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

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        UserSeeder userSeeder = new UserSeeder(passwordEncoder, userRepository);
        userSeeder.run();
    }

}
