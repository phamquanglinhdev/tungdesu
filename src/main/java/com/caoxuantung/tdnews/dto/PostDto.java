package com.caoxuantung.tdnews.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link com.caoxuantung.tdnews.models.Post} entity
 */
public class PostDto implements Serializable {
    private final String title;
    private final UserDto author;
    private final String document;
    private final Date date;

    public PostDto(String title, UserDto author, String document, Date date) {
        this.title = title;
        this.author = author;
        this.document = document;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public UserDto getAuthor() {
        return author;
    }

    public String getDocument() {
        return document;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDto entity = (PostDto) o;
        return Objects.equals(this.title, entity.title) &&
                Objects.equals(this.author, entity.author) &&
                Objects.equals(this.document, entity.document) &&
                Objects.equals(this.date, entity.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, document, date);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "title = " + title + ", " +
                "author = " + author + ", " +
                "document = " + document + ", " +
                "date = " + date + ")";
    }
}