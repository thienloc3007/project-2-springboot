package com.example.jpa_project2;

import com.example.jpa_project2.model.Article;
import com.example.jpa_project2.model.Category;
import com.example.jpa_project2.repo.ArticleRepository;
import com.example.jpa_project2.repo.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Optional;


@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;


    public ArticleService(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    //Create
    public Article create(
            String title,
            String content,
            String articlePassword,
            Integer categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow();
        Article article = new Article(title, content, articlePassword, category);

        return articleRepository.save(article);
    }


    //ReadAllArticle
    public List<Article> readAll() {
        return articleRepository.findAll();
    }

    //ReadAllbyCategoryId
    public List<Article> readAllbyCategoryId(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        
        return category.getArticle();}

    //ReadOne
    public Article readOne(Integer id) {
        return articleRepository.findById(id).orElse(null);
    }

    //Update
    public Article update(
            Integer id,
            String title,
            String content,
            String articlePassword,
            String category) {
        Optional<Article> optionalTarget = articleRepository.findById(id);
        if (optionalTarget.isEmpty()) {
            return null;
        }

                //target.setArticlePassword(articlePassword);

            Article target = optionalTarget.get();
            target.setTitle(title);
            target.setContent(content);

            return articleRepository.save(target);
        }

    //Delete
    public void delete (Integer id) {
        articleRepository.deleteById(id);
    }
    }



