package com.example.jpa_project2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Article> article;

    public  Category() {}

    public Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }
}
