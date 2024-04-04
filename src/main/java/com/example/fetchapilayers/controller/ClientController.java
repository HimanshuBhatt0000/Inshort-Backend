package com.example.fetchapilayers.controller;

import com.example.fetchapilayers.dao.Article;
import com.example.fetchapilayers.model.ArticleResponse;
import com.example.fetchapilayers.service.FetchArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    FetchArticleService fetchArticleService;

    @GetMapping("/fetch-article")
    public ResponseEntity<List<ArticleResponse>> fetchArticle(@RequestParam String tag){
        return fetchArticleService.getArticleByCategory(tag);
    }
}
