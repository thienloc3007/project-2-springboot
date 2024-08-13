package com.example.jpa_project2;

import com.example.jpa_project2.model.Article;
import com.example.jpa_project2.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import com.example.jpa_project2.ArticleService;

@Controller
@RequestMapping("articles")
public class ArticleController {
    private final ArticleService articleService;
    private final CategoryService categoryService;

    public ArticleController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    //Create
    @GetMapping("create")
    public String createView(Model model) {
        categoryService.create();
        model.addAttribute("categoryList", categoryService.readAll());
        return "articles/create.html";
    }

    @PostMapping("create")
    public String create(
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("articlePassword")
            String articlePassword,
            @RequestParam("categoryId")
            Integer categoryId) {

        Integer id = articleService.create(title, content, articlePassword, categoryId).getId();
        return String.format("redirect:/articles/%d", id);
    }


    //ReadAllArticle
    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("articles", articleService.readAll());
        return "articles/home.html";
    }

    //ReadAllbyCategoryId
    @GetMapping("category/{categoryId}")
    public String readAllbyCategoryId(
            @PathVariable("categoryId")
            Integer categoryId,
            Model model) {
        model.addAttribute("articles", articleService.readAllbyCategoryId(categoryId));
        model.addAttribute("categoryname", categoryService.readOne(categoryId).getTitle());
        return "articles/category.html";

    }


    //ReadOne
    @GetMapping("{id}")
    public String readOne(
            @PathVariable("id")
            Integer id,
            Model model) {

        model.addAttribute("article", articleService.readOne(id));
        return "articles/read.html";
    }

    //Update
//    @GetMapping("{id}/update")
//    public String updateView(
//            @PathVariable("id")
//            Integer id,
//            Model model) {
//        model.addAttribute("article", articleService.readOne(id));
//        return "articles/update.html";
//    }

    @PostMapping("{id}/doUpdate")
    public String update(
            @PathVariable("id")
            Integer id,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            String articlePassword,
            String category) {
        //password
        articleService.update(id, title, content, articlePassword, category);
        return String.format("redirect:/articles/%d", id);
//        return "thành công";
    }

    //delete
    @PostMapping("{id}/delete")
    public String delete(
            @PathVariable("id")
            Integer id) {
        articleService.delete(id);
        return "redirect:/articles";
    }

    //Password Check View
    @GetMapping("{id}/update")
    public String passwordCheckView(
            @PathVariable("id")
            Integer id,
            Model model) {
        model.addAttribute("article", articleService.readOne(id));
        return "articles/passwordCheck.html";
    }

    @PostMapping("{id}/update")
    public String passwordCheck(
            @PathVariable("id")
            Integer id,
            @RequestParam("password")
            String password,
            Model model) {
        Article targetArticle = articleService.readOne(id);
        if(password.equals(targetArticle.getArticlePassword())){
            model.addAttribute("article", articleService.readOne(id));
            return "articles/update.html";
        }
        return "articles/wrongPassword.html";
}

}