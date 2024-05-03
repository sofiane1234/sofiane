package com.ynov.sofiane.services;

import com.ynov.sofiane.models.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Optional<Article> getArticleById(Long id);
    List<Article> getAllArticles();
    Article createArticle(Article article);
}
