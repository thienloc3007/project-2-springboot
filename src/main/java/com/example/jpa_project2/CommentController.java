package com.example.jpa_project2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("articles/{articleId}/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //Create
//    html://articles/{articleID}/comments/create"
    @PostMapping("create")
    public String create(
            @PathVariable("articleId")
            Integer articleId,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer,
            @RequestParam("commentPassword")
            String commentPassword) {
        commentService.create(articleId, content, writer, commentPassword );
        return String.format("redirect:/articles/%d", articleId);
    }

//        //Read One
//    @GetMapping("{id}")
//    public String readOne(
//            @PathVariable("id")
//            Long id,
//            Model model) {
//
//        model.addAttribute("article", commentService.readOne(id).getArticle(id));
//        return "articles/read.html";
//    }


}

