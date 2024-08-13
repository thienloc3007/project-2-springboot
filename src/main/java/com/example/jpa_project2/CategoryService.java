package com.example.jpa_project2;

import com.example.jpa_project2.model.Category;
import com.example.jpa_project2.model.Comment;
import com.example.jpa_project2.repo.CategoryRepository;
import com.example.jpa_project2.repo.CommentRepository;
import com.example.jpa_project2.model.Article;
import com.example.jpa_project2.repo.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public CategoryService(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    public void create() {
        if (categoryRepository.findAll().isEmpty()) {
        Category category1 = new Category("Hot deals");
        Category category2 = new Category("Jobs & Career");
        Category category3 = new Category("Daily News");
        Category category4 = new Category("Cautions");
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);}
    }

    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    public Category readOne(Integer id) {
        return categoryRepository.findById(id).orElseThrow(null);


    }
}



