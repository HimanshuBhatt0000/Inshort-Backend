package com.example.fetchapilayers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FetchApiLayersApplicationTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:9081";
    }

    @ParameterizedTest
    @ValueSource(strings = { "SPORTS", "LIFESTYLE", "POLITICS" })
    void testFetchArticle(String tag) {
        Response response = RestAssured.get("/fetch-article?tag=" + tag);

        // Assert response
        assertEquals(200, response.getStatusCode());
        System.out.println("Tag: " + tag);
        System.out.println("Status Code: " + response.getStatusCode());

        System.out.println("Status Body: " + response.getBody().asString());
        System.out.println("Status Time Taken: " + response.getTime());
        System.out.println("Status Header: " + response.getHeader("content-type"));
    }
}
