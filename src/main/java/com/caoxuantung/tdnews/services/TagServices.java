package com.caoxuantung.tdnews.services;

import com.caoxuantung.tdnews.models.Tag;
import com.caoxuantung.tdnews.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServices {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAll() {
       return tagRepository.findAll();
    }

}
