package com.caoxuantung.tdnews.seed;

import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.models.User;
import com.caoxuantung.tdnews.repositories.CategoryRepository;
import com.caoxuantung.tdnews.repositories.PostRepository;
import com.caoxuantung.tdnews.repositories.UserRepository;

public class PostSeeder {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private final CategoryRepository categoryRepository;

    public PostSeeder(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public void run() {
        User user = userRepository.findByEmail("alex.cao@gmail.com");
        if (postRepository.findById(1L).isEmpty()) {
            Post post = new Post();
            post.setAuthor(user);
            post.setAvatar("https://thumbs.dreamstime.com/b/make-things-better-closeup-hand-place-wood-letters-table-as-motivation-quote-148971444.jpg");
            post.setCategory(categoryRepository.findByName("Movie"));
            post.setTitle("Working on Memorial Day: How to Make It Better for Your Team");
            post.setDescription("Historically, many workers have had time off from work for Memorial Day, the informal start of summer. Unfortunately, plenty of people still have to go to work on the holiday. While that might not be great for employees, it is sometimes unavoidable from a business perspective. Some businesses can’t close on weekends or holidays, while many seasonal businesses first open on Memorial Day and need revenue to make up for the down season.");
            post.setDocument("Historically, many workers have had time off from work for Memorial Day, the informal start of summer. Unfortunately, plenty of people still have to go to work on the holiday. While that might not be great for employees, it is sometimes unavoidable from a business perspective. Some businesses can’t close on weekends or holidays, while many seasonal businesses first open on Memorial Day and need revenue to make up for the down season.");
            post.setId(1L);
            postRepository.save(post);
        }
        if (postRepository.findById(2L).isEmpty()) {
            Post post = new Post();
            post.setAuthor(user);
            post.setAvatar("https://thumbs.dreamstime.com/b/make-things-better-closeup-hand-place-wood-letters-table-as-motivation-quote-148971444.jpg");
            post.setCategory(categoryRepository.findByName("Movie"));
            post.setTitle("Avatar: The Way of Water Review: James Cameron Gives Us the Biggest ‘Video Game Movie’ Ever");
            post.setDescription("Avatar: The Way of Water — now playing in cinemas worldwide — has a gargantuan task on its hands. (And I'm not even talking about the sequel's need to earn over a billion dollars at the box office to turn a profit.) James Cameron, the returning director, co-writer, co-editor, and co-producer on the second Avatar movie, must prove to audiences that his world of Pandora is worth revisiting thirteen years on. The original Avatar was both a showcase of 3D cinema and otherworldly visuals. One of them is on its last legs, while VFX and scale are seemingly everywhere these days. The spectacle alone — Cameron had little to offer on the story and characters front back then — cannot carry Avatar: The Way of Water. It needs more.");
            post.setDocument("Avatar: The Way of Water — now playing in cinemas worldwide — has a gargantuan task on its hands. (And I'm not even talking about the sequel's need to earn over a billion dollars at the box office to turn a profit.) James Cameron, the returning director, co-writer, co-editor, and co-producer on the second Avatar movie, must prove to audiences that his world of Pandora is worth revisiting thirteen years on. The original Avatar was both a showcase of 3D cinema and otherworldly visuals. One of them is on its last legs, while VFX and scale are seemingly everywhere these days. The spectacle alone — Cameron had little to offer on the story and characters front back then — cannot carry Avatar: The Way of Water. It needs more.");
            post.setId(2L);
            postRepository.save(post);
        }
    }
}
