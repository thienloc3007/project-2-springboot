package com.example.jpa_project2;

import com.example.jpa_project2.model.Comment;
import com.example.jpa_project2.repo.CommentRepository;
import com.example.jpa_project2.model.Article;
import com.example.jpa_project2.repo.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final ArticleRepository articleRepository  ;
    private final CommentRepository commentRepository;

    public CommentService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public Comment create(
            Integer articleId,
            String content,
            String writer,
            String commentPassword
    ) {
        Article article = articleRepository.findById(articleId).orElseThrow();
        Comment comment = new Comment(content, writer, commentPassword, article);
        return commentRepository.save(comment);
    }

    public Comment readOne(Integer articleID, Integer commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(null);
        if(!comment.getArticle().getId().equals(articleID))
            throw new RuntimeException();
        return comment;
    }

    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }
}
