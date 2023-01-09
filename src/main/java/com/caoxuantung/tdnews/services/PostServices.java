package com.caoxuantung.tdnews.services;

import com.caoxuantung.tdnews.config.ModelMapperConfig;
import com.caoxuantung.tdnews.dto.PostDto;
import com.caoxuantung.tdnews.dto.UserDto;
import com.caoxuantung.tdnews.models.Post;
import com.caoxuantung.tdnews.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServices {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getNewestPost() {
        return postRepository.findTop6ByOrderByCreatedDesc();
    }

    public List<Post> getTrendingPost() {
        return postRepository.findTop3ByOrderByCommentsDesc();
    }

    public List<Post> getRecentPost() {
        return postRepository.findTop3ByOrderByUpdatedDesc();
    }


}
