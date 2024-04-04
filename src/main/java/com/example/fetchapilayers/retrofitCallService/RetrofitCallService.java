package com.example.fetchapilayers.retrofitCallService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service
@Slf4j
public class RetrofitCallService {

    @Autowired
    private EconomicTimesCall economicTimesCall;


//    public ResponseEntity<String> triggerDataScrapping() {
//        try {
//            log.info("Calling Retrofit");
//            Response<String> response = economicTimesCall.test().execute();
//            if (response.isSuccessful()) {
//                return ResponseEntity.ok(response.body());
//            } else {
//                return ResponseEntity.status(response.code()).body(response.errorBody().string());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(500).body("Internal Server Error");
//        }
//    }
    public ResponseEntity<String> triggerDataScrappingByCategory(String  tag) {
        try {
            log.info("Calling Retrofit");
            Response<String> response = economicTimesCall.fetchByCategory(tag).execute();
            if (response.isSuccessful()) {
                return ResponseEntity.ok(response.body());
            } else {
                return ResponseEntity.status(response.code()).body(response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}
