package com.caoxuantung.tdnews.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;
import java.util.Date;


@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @Column(length = 1000000)
    private String document;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date created;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated;

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Post() {
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }


}