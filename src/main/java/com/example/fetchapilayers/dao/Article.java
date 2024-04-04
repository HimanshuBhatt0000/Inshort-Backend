package com.example.fetchapilayers.dao;


import com.example.fetchapilayers.constants.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl ;

    private String title ;

    @Column(columnDefinition = "LONGTEXT")
    private String summary;

    private String source;

    @Enumerated(EnumType.STRING)
    private Tag tag;

}
