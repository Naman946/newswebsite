package com.development.newswebsite.service;

import com.development.newswebsite.domain.Article;
import com.development.newswebsite.repository.ArticleRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    
 // Method to retrieve all articles from the database
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }
    
    public List<Article> getArticlesByCategoryId(String categoryId) {
        return articleRepository.findByCategoryId(categoryId);
    }
}