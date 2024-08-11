package com.development.newswebsite.v1;

import com.development.newswebsite.domain.Advertisement;
import com.development.newswebsite.domain.Article;
import com.development.newswebsite.service.AdvertisementService;
import com.development.newswebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@CrossOrigin(origins = "https://bharatsamvad.netlify.app", allowCredentials = "true")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

     @Autowired
    private AdvertisementService advertisementService;

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

   //post for create advertisment
    @PostMapping("/advertisement")
    public Advertisement createAdvertisement(
            @RequestParam("type") String type,
            @RequestParam(value = "date", required = false) Date date,
            @RequestParam("image") MultipartFile file) throws IOException {
        
        Advertisement advertisement = new Advertisement();
        advertisement.setType(type);
        
        // Set current date if date is not provided
        if (date == null) {
            date = new Date();
        }
        advertisement.setDate(date);
        
        // Convert image to Base64 string
        byte[] fileContent = file.getBytes();
        String base64Image = Base64.getEncoder().encodeToString(fileContent);
        advertisement.setImage(base64Image);
        
        return advertisementService.createAdvertisement(advertisement);
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

    // GET endpoint to fetch all advertisements
    @GetMapping("/advertisements")
    public List<Advertisement> getAllAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }
}
