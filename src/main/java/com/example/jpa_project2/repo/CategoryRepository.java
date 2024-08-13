package com.example.jpa_project2.repo;

import com.example.jpa_project2.model.Comment;
import com.example.jpa_project2.model.Article;
import com.example.jpa_project2.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository
extends  JpaRepository<Category, Integer> {
}
