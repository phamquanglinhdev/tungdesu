package com.caoxuantung.tdnews.seed;


import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.UserRepository;
import jdk.jfr.Enabled;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

@Enabled
public class UserSeeder {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserSeeder(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Bean
    public void run() {
        if (userRepository.findByEmail("alex.cao@gmail.com") == null) {
            Random gen = new Random();
            User user = new User();
            user.setAvatar("https://ngonaz.com/wp-content/uploads/2022/01/cach-ve-anime-2.jpg");
            user.setName("Alex Cao");
            user.setEmail("alex.cao@gmail.com");
            user.setPassword(passwordEncoder.encode("99999999"));
            user.setRole("admin");
            user.setRemember("AIDJASPOmoquwdq90sd");
            userRepository.save(user);
        }
        if (userRepository.findByEmail("jenifer@gmail.com") == null) {
            Random gen = new Random();
            User user = new User();
            user.setAvatar("https://i1.sndcdn.com/artworks-000248908839-wlug27-t500x500.jpg");
            user.setName("Jenifer Patter");
            user.setEmail("jenifer@gmail.com");
            user.setPassword(passwordEncoder.encode("99999999"));
            user.setRole("author");
            user.setRemember("AIDJASPOmoquwdq90sd");
            userRepository.save(user);
        }
        if (userRepository.findByEmail("adams@gmail.com") == null) {
            Random gen = new Random();
            User user = new User();
            user.setName("Adams Little");
            user.setEmail("adams@gmail.com");
            user.setPassword(passwordEncoder.encode("99999999"));
            user.setRole("viewer");
            user.setRemember("AIDJASPOmoquwdq90sd");
            userRepository.save(user);
        }
    }
}
