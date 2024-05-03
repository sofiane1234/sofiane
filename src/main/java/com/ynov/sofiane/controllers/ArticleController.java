package com.ynov.sofiane.controllers;

import com.ynov.sofiane.models.Article;
import com.ynov.sofiane.services.ArticleService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<>(
                articleService.getAllArticles(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        return new ResponseEntity<>(
                articleService.createArticle(article),
                HttpStatus.CREATED
        );
    }
}
