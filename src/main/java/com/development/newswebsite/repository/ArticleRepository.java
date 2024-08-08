package com.development.newswebsite.repository;

import com.development.newswebsite.domain.Article;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
	List<Article> findByCategoryId(String categoryId);
}