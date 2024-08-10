package com.development.newswebsite.v1;

import com.development.newswebsite.domain.Article;
import com.development.newswebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@CrossOrigin(origins = "https://bharatsamvad.netlify.app", allowCredentials = "true")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Article createArticle(@RequestParam("title") String title,
                                 @RequestParam("content") String content,
                                 @RequestParam("image") MultipartFile file) throws IOException {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        
        // Convert image to Base64 string
        byte[] fileContent = file.getBytes();
        String base64Image = Base64.getEncoder().encodeToString(fileContent);
        article.setImage(base64Image);
        
        return articleService.createArticle(article);
    }
 // GET endpoint to fetch all articles
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }
    
    @GetMapping("/by-category")
    public List<Article> getArticlesByCategory(@RequestParam String categoryId) {
        return articleService.getArticlesByCategoryId(categoryId);
    }
}
