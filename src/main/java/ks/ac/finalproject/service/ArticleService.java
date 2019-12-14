package ks.ac.finalproject.service;

import ks.ac.finalproject.domain.Article;
import ks.ac.finalproject.domain.ArticleDto;
import ks.ac.finalproject.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

@Service
public class ArticleService {

//    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
//    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
//
//    private ArticleRepository articleRepository;
//
//    public ArticleService(ArticleRepository articleRepository) {
//        this.articleRepository = articleRepository;
//    }
//
//    public Mono<Article> create(ArticleDto articleDto) {
//        Mono<Article> articleMono = articleRepository.save(Article.builder()
//                .title(articleDto.getTitle())
//                .description(articleDto.getDescription())
//                .body(articleDto.getBody())
//                .tags(articleDto.getTags())
//                .slug(toSlug(articleDto.getTitle()))
//                .build());
//        return articleMono;
//    }
//
//    public Mono<Article> bySlug(String slug) {
//        return articleRepository.findBySlug(slug);
//    }
//
//    public Mono<Article> update(String slug, String title) {
//        return articleRepository.findBySlug(slug).flatMap(article -> {
//            article.setTitle(title);
//            return articleRepository.save(article);
//        });
//    }
//
//    public Mono<Void> delete(String slug) {
//        return articleRepository.findBySlug(slug).flatMap(article -> articleRepository.delete(article));
//    }
//
//    public String toSlug(String input) {
//        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
//        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
//        String slug = NONLATIN.matcher(normalized).replaceAll("");
//        return slug.toLowerCase(Locale.ENGLISH);
//    }
}
