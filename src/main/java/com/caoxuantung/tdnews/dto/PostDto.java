package com.caoxuantung.tdnews.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.caoxuantung.tdnews.models.Post} entity
 */
public class PostDto implements Serializable {
    private final String title;
    private final String avatar;
    private final UserDto author;
    private final String document;
    private final CategoryDto category;
    private final Date created;
    private final Date updated;
    private final Collection<CommentDto> comments;
    private final Collection<TagDto> tags;

    public PostDto(String title, String avatar, UserDto author, String document, CategoryDto category, Date created, Date updated, Collection<CommentDto> comments, Collection<TagDto> tags) {
        this.title = title;
        this.avatar = avatar;
        this.author = author;
        this.document = document;
        this.category = category;
        this.created = created;
        this.updated = updated;
        this.comments = comments;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAvatar() {
        return avatar;
    }

    public UserDto getAuthor() {
        return author;
    }

    public String getDocument() {
        return document;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Collection<CommentDto> getComments() {
        return comments;
    }

    public Collection<TagDto> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto entity = (PostDto) o;
        return Objects.equals(this.title, entity.title) &&
                Objects.equals(this.avatar, entity.avatar) &&
                Objects.equals(this.author, entity.author) &&
                Objects.equals(this.document, entity.document) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.created, entity.created) &&
                Objects.equals(this.updated, entity.updated) &&
                Objects.equals(this.comments, entity.comments) &&
                Objects.equals(this.tags, entity.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, avatar, author, document, category, created, updated, comments, tags);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "title = " + title + ", " +
                "avatar = " + avatar + ", " +
                "author = " + author + ", " +
                "document = " + document + ", " +
                "category = " + category + ", " +
                "created = " + created + ", " +
                "updated = " + updated + ", " +
                "comments = " + comments + ", " +
                "tags = " + tags + ")";
    }
}