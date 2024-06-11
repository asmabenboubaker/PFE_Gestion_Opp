package biz.picosoft.demo.controller;


import biz.picosoft.demo.domain.Article;
import biz.picosoft.demo.service.impl.ArticleServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleServiceImp articleService;


    public ArticleController(ArticleServiceImp articleService) {
        this.articleService = articleService;
    }
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article createdArticle = articleService.createArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        Article article = articleService.updateArticle(id, updatedArticle);
        return ResponseEntity.ok(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/assignToOffreDePrix/{offreDePrixId}")
    public ResponseEntity<Article> createArticleAndAssignToOffreDePrix(@PathVariable Long offreDePrixId, @RequestBody Article article) {
        Article createdArticle = articleService.createArticleAndAssignToOffreDePrix(offreDePrixId, article);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdArticle);
    }
}
