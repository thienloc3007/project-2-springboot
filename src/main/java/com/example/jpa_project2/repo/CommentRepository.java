package com.example.jpa_project2.repo;

import com.example.jpa_project2.model.Comment;
import com.example.jpa_project2.model.Article;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository
    extends JpaRepository<Comment, Integer> {
}
