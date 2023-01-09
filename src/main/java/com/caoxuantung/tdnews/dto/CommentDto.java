package com.caoxuantung.tdnews.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.caoxuantung.tdnews.models.Comment} entity
 */
public class CommentDto implements Serializable {
    private final String message;
    private final UserDto user;
    private final PostDto post;
    private final Date created;

    public CommentDto(String message, UserDto user, PostDto post, Date created) {
        this.message = message;
        this.user = user;
        this.post = post;
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public UserDto getUser() {
        return user;
    }

    public PostDto getPost() {
        return post;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto entity = (CommentDto) o;
        return Objects.equals(this.message, entity.message) &&
                Objects.equals(this.user, entity.user) &&
                Objects.equals(this.post, entity.post) &&
                Objects.equals(this.created, entity.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, user, post, created);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "message = " + message + ", " +
                "user = " + user + ", " +
                "post = " + post + ", " +
                "created = " + created + ")";
    }
}