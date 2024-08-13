package com.example.jpa_project2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import java.awt.*;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String articlePassword;


    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    @ManyToOne
    private Category category;

    public Article() {
    }

    public Article(String title, String content, String articlePassword, Category category) {
        this.title = title;
        this.content = content;
        this.articlePassword = articlePassword;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticlePassword() {
        return articlePassword;
    }

    public void setArticlePassword(String articlePassword) {
        this.articlePassword = articlePassword;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}