package com.example.jpa_project2;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("articles/{categoryId}")

public class CategoryController {
        private final CategoryService categoryService;
        public final ArticleService articleService;

    public CategoryController(CategoryService categoryService,
                              ArticleService articleService) {
        this.categoryService = categoryService;
        this.articleService = articleService;
    }


}
