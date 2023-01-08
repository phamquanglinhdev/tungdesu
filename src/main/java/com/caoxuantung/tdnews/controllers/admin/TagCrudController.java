package com.caoxuantung.tdnews.controllers.admin;

import com.caoxuantung.tdnews.models.Tag;
import com.caoxuantung.tdnews.models.Tag;
import com.caoxuantung.tdnews.repositories.TagRepository;
import com.caoxuantung.tdnews.repositories.TagRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("admin/tag")
public class TagCrudController {
    private final TagRepository tagRepository;

    public TagCrudController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @GetMapping(value = {"", "index"})
    public String index(Model model) {
        model.addAttribute("tags", tagRepository.findAll());
        return "admin/tag/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("tag", new Tag());
        model.addAttribute("mode", "store");
        return "admin/tag/create";
    }

    @GetMapping("edit/{id}")
    public String create(@PathVariable Long id, Model model) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            Tag updateTag = optionalTag.get();
            model.addAttribute("tag", updateTag);
            model.addAttribute("mode", "update");
        }
        return "admin/tag/create";
    }

    @PostMapping("store")
    public String create(@ModelAttribute Tag tag) {
        tagRepository.save(tag);
        return "redirect:/admin/tag";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Tag tag) {
        Optional<Tag> optionalTag = tagRepository.findById(tag.getId());
        if (optionalTag.isPresent()) {
            Tag updateTag = optionalTag.get();
            updateTag.setName(tag.getName());
            tagRepository.save(updateTag);
        }
        return "redirect:/admin/tag";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            Tag tag = optionalTag.get();
            tagRepository.delete(tag);
        }
        return "redirect:/admin/tag";
    }
}
