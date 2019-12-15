package ks.ac.finalproject.controller;

import ks.ac.finalproject.domain.Article;
import ks.ac.finalproject.domain.ArticleVo;
import ks.ac.finalproject.service.ArticleService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/api/articles/{slug}")
    public Mono<Article> getArticle(@PathVariable String slug) {
        return articleService.bySlug(slug);
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Mono<Article>> createArticle(@RequestHeader("token") String token, @RequestBody ArticleVo articleVo) {
        Mono<Article> articleMono=articleService.create(articleVo);
        token="aa";
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.set("token",token);
        return ResponseEntity.ok().headers(httpHeaders).body(articleMono);
    }

    @PutMapping("/api/article/{slug}")
    public Mono<Article> updateArticle(@PathVariable String slug, String title) {
        return articleService.update(slug, title);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/api/article/{slug}")
    public Mono<Void> deleteArticle(@PathVariable String slug) {
        return articleService.delete(slug);
    }
}
