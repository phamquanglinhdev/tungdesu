package com.caoxuantung.tdnews.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link com.caoxuantung.tdnews.models.Category} entity
 */
public class CategoryDto implements Serializable {
    private final String name;
    private final Collection<PostDto> posts;

    public CategoryDto(String name, Collection<PostDto> posts) {
        this.name = name;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public Collection<PostDto> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto entity = (CategoryDto) o;
        return Objects.equals(this.name, entity.name) &&
                Objects.equals(this.posts, entity.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, posts);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ", " +
                "posts = " + posts + ")";
    }
}