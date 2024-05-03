package com.ynov.sofiane.implems;

import com.ynov.sofiane.models.Article;
import com.ynov.sofiane.repositories.ArticleRepo;
import com.ynov.sofiane.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ArticleImplem implements ArticleService {
    @Autowired
    ArticleRepo articleRepo;

    @Override
    public Optional<Article> getArticleById(Long id) {
        return articleRepo.findById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepo.findAll();
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepo.save(article);
    }
}
