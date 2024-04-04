package com.example.fetchapilayers.model;

import com.example.fetchapilayers.constants.Tag;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleResponse {
    private String imageUrl ;

    private String title ;

    private String summary;

    private String source;

    private Tag tag;
}
