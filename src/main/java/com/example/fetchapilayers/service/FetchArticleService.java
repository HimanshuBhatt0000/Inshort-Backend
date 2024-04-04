package com.example.fetchapilayers.service;

import com.example.fetchapilayers.constants.Tag;
import com.example.fetchapilayers.dao.Article;
import com.example.fetchapilayers.model.ArticleResponse;
import com.example.fetchapilayers.repositories.ArticleRepository;
import com.example.fetchapilayers.retrofitCallService.RetrofitCallService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FetchArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    RetrofitCallService retrofitCallService;
    public ResponseEntity<List<ArticleResponse>> getArticleByCategory(String tag){
        try{
            Tag tagEnum = Tag.valueOf(tag);

//           ResponseEntity<String> retrofitResponse = retrofitCallService.triggerDataScrappingByCategory(tag);

//            if(!retrofitResponse.getStatusCode().equals(HttpStatusCode.valueOf(200))){
//                log.info("RetrofitCallFailed , Data scrapping incomplete");
//                return new ResponseEntity<>(HttpStatusCode.valueOf(400));
//            }


            List<Article> articleList = articleRepository.findByTag(tagEnum);
            List<ArticleResponse> articleResponseList = new ArrayList<>();
            for(Article article : articleList){
                ArticleResponse response = new ArticleResponse();
                response.setTag(article.getTag());
                response.setSummary(article.getSummary());
                response.setTitle(article.getTitle());
                response.setSource(article.getSource());
                response.setImageUrl(article.getImageUrl());

                articleResponseList.add(response);

            }
            return ResponseEntity.ok(articleResponseList);
        }
        catch(Exception e){
        log.info("Exception in getArticleByCategory");
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
