package com.example.fetchapilayers.repositories;

import com.example.fetchapilayers.constants.Tag;
import com.example.fetchapilayers.dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    List<Article> findByTag(Tag tagEnum);
}
