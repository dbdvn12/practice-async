package ks.ac.finalproject.repository;

import ks.ac.finalproject.domain.Article;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ArticleRepository extends ReactiveMongoRepository<Article, String> {
    Mono<Article> findBySlug(String slug);
}
