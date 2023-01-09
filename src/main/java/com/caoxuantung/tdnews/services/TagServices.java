package com.caoxuantung.tdnews.services;

import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.models.Tag;
import com.caoxuantung.tdnews.repositories.PostRepository;
import com.caoxuantung.tdnews.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServices {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findById(Long id) {
        return tagRepository.findById(id);
    }

    public List<Post> getPosts(Long id) {
        return postRepository.findByTagsIdOrderByCreatedDesc(id);
    }

}
