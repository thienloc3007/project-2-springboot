package com.example.jpa_project2.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private  String writer;
    private  String commentPassword;

    @ManyToOne
    private Article article;

    public Comment () {}

    public Comment(String content, String writer, String password, Article article) {
        this.content = content;
        this.writer = writer;
        this.commentPassword = commentPassword;
        this.article = article;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPassword() {
        return commentPassword;
    }

    public void setPassword(String password) {
        this.commentPassword = password;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
